from flask import Flask, request
from flask_cors import CORS
from flask_jwt_extended import (
    JWTManager,
    create_access_token,
    get_jwt_identity,
    jwt_required,
)
from flask_restx import Api, Namespace, Resource, fields
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import check_password_hash, generate_password_hash

# -----------------------------------------------------------
# CONFIGURACIÓN BÁSICA
# -----------------------------------------------------------
app = Flask(__name__)

CORS(
    app,
    resources={r"/*": {"origins": "*"}},
    supports_credentials=True,
    expose_headers=["Content-Type", "Authorization"],
    allow_headers=["Content-Type", "Authorization"],
)

app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///splitexpenser.db"
app.config["JWT_SECRET_KEY"] = "secret-jwt-key"
app.config["JWT_ALGORITHM"] = "HS256"
db = SQLAlchemy(app)
jwt = JWTManager(app)

# -----------------------------------------------------------
# API PRINCIPAL
# -----------------------------------------------------------
authorizations = {"jwt": {"type": "apiKey", "in": "header", "name": "Authorization"}}

api = Api(
    app,
    title="Splitexpenser API",
    version="1.0",
    description="API para gestión de gastos en grupo",
    authorizations=authorizations,
    security=None,
)

# -----------------------------------------------------------
# MODELOS DE BASE DE DATOS
# -----------------------------------------------------------
group_members = db.Table(
    "group_members",
    db.Column("user_id", db.Integer, db.ForeignKey("user.id")),
    db.Column("group_id", db.Integer, db.ForeignKey("group.id")),
    db.Column("joined_at", db.DateTime, default=db.func.current_timestamp()),
    db.Column("removed_at", db.DateTime, nullable=True),
)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    password = db.Column(db.String(200), nullable=False)
    created_at = db.Column(db.DateTime, default=db.func.current_timestamp())
    groups = db.relationship("Group", secondary=group_members, back_populates="users")


class Group(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120))
    users = db.relationship("User", secondary=group_members, back_populates="groups")
    expenses = db.relationship("Expense", backref="group", lazy=True)


class Expense(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    description = db.Column(db.String(120))
    amount = db.Column(db.Float)
    group_id = db.Column(db.Integer, db.ForeignKey("group.id"))
    paid_by = db.Column(db.Integer, db.ForeignKey("user.id"))


def error_response(message, status_code=400):
    return {"msg": message}, status_code


# -----------------------------------------------------------
# MODELOS SWAGGER
# -----------------------------------------------------------
registration_model = api.model(
    "Registration",
    {
        "username": fields.String(required=True, description="Nombre de usuario"),
        "password": fields.String(required=True, description="Contraseña"),
    },
)

login_model = api.model(
    "Login",
    {
        "username": fields.String(required=True, description="Nombre de usuario"),
        "password": fields.String(required=True, description="Contraseña"),
    },
)

group_creation_model = api.model(
    "GroupCreation",
    {"name": fields.String(required=True, description="Nombre del grupo")},
)

add_member_model = api.model(
    "AddMember",
    {
        "username": fields.String(
            required=True, description="Nombre de usuario a añadir al grupo"
        ),
    },
)

expense_creation_model = api.model(
    "ExpenseCreation",
    {
        "description": fields.String(
            required=True, description="Descripción del gasto"
        ),
        "amount": fields.Float(required=True, description="Monto del gasto"),
    },
)

expense_update_model = api.model(
    "ExpenseUpdate",
    {
        "description": fields.String(description="Nueva descripción del gasto"),
        "amount": fields.Float(description="Nuevo monto del gasto"),
    },
)

# -----------------------------------------------------------
# NAMESPACES
# -----------------------------------------------------------
auth_ns = Namespace("auth", description="Autenticación y registro de usuarios")
groups_ns = Namespace("groups", description="Gestión de grupos")
expenses_ns = Namespace("expenses", description="Gestión de gastos")


# -----------------------------------------------------------
# AUTH NAMESPACE
# -----------------------------------------------------------
@auth_ns.route("/register")
class Register(Resource):
    @auth_ns.expect(registration_model, validate=True)
    def post(self):
        """Registra un nuevo usuario"""
        if not request.is_json:
            return error_response("Missing JSON body", 400)
        data = request.get_json()
        username = data.get("username")
        password = data.get("password")

        if not username or not password:
            return error_response("Both 'username' and 'password' are required", 400)

        if User.query.filter_by(username=username).first():
            return error_response("User already exists", 409)

        hashed_pw = generate_password_hash(password)
        user = User(username=username, password=hashed_pw)
        db.session.add(user)
        db.session.commit()
        return {"msg": "User registered"}


@auth_ns.route("/login")
class Login(Resource):
    @auth_ns.expect(login_model, validate=True)
    def post(self):
        data = request.get_json()
        username = data.get("username")
        password = data.get("password")

        user = User.query.filter_by(username=username).first()
        if user and check_password_hash(user.password, password):
            token = create_access_token(identity=str(user.id))
            return {"access_token": token}, 200

        return {"msg": "Bad credentials"}, 401


@auth_ns.route("/unregister")
class Unregister(Resource):
    @jwt_required()
    @auth_ns.expect(registration_model, validate=True)
    def post(self):
        """Elimina la cuenta del usuario autenticado, verificando la contraseña"""
        user_id = get_jwt_identity()
        user = db.session.get(User, user_id)
        if not user:
            return error_response("User not found", 404)

        data = request.get_json()
        password = data.get("password")
        if not password or not check_password_hash(user.password, password):
            return error_response("Invalid password", 401)

        db.session.delete(user)
        db.session.commit()
        return {"msg": "User unregistered"}


# -----------------------------------------------------------
# GROUPS NAMESPACE
# -----------------------------------------------------------
@groups_ns.route("")
class GroupList(Resource):
    @jwt_required()
    def get(self):
        """Lista los grupos del usuario autenticado"""
        user_id = get_jwt_identity()
        user = db.session.get(User, user_id)
        if not user:
            return error_response("User not found", 404)
        return [{"id": g.id, "name": g.name} for g in user.groups]

    @jwt_required()
    @groups_ns.expect(group_creation_model, validate=True)
    def post(self):
        """Crea un nuevo grupo"""
        data = request.get_json()
        name = data.get("name")
        if not name:
            return error_response("Group 'name' is required", 400)
        user_id = get_jwt_identity()
        user = db.session.get(User, user_id)
        if not user:
            return error_response("User not found", 404)
        group = Group(name=name)
        group.users.append(user)
        db.session.add(group)
        db.session.commit()
        return {"id": group.id, "name": group.name}


@groups_ns.route("/<int:group_id>")
class GroupDetail(Resource):
    @jwt_required()
    def get(self, group_id):
        """Obtiene los detalles de un grupo"""
        group = db.session.get(Group, group_id)
        if not group:
            return error_response("Group not found", 404)
        return {
            "id": group.id,
            "name": group.name,
            "members": [u.username for u in group.users],
        }

    @jwt_required()
    @groups_ns.expect(add_member_model, validate=True)
    def post(self, group_id):
        """Añade un miembro al grupo"""
        data = request.get_json()
        username = data.get("username")
        if not username:
            return error_response("'username' is required", 400)
        user = User.query.filter_by(username=username).first()
        group = db.session.get(Group, group_id)
        if not user:
            return error_response("User not found", 404)
        if not group:
            return error_response("Group not found", 404)
        if user in group.users:
            return error_response("User already in group", 400)
        group.users.append(user)
        db.session.commit()
        return {"msg": "User added"}


# -----------------------------------------------------------
# EXPENSES NAMESPACE
# -----------------------------------------------------------
@expenses_ns.route("/<int:group_id>/expenses")
class ExpenseList(Resource):
    @jwt_required()
    def get(self, group_id):
        """Lista los gastos de un grupo"""
        group = db.session.get(Group, group_id)
        if not group:
            return error_response("Group not found", 404)
        expenses = [
            {
                "id": e.id,
                "desc": e.description,
                "amount": e.amount,
                "paid_by": e.paid_by,
            }
            for e in group.expenses
        ]
        return expenses

    @jwt_required()
    @expenses_ns.expect(expense_creation_model, validate=True)
    def post(self, group_id):
        """Crea un nuevo gasto"""
        data = request.get_json()
        description = data.get("description")
        amount = data.get("amount")
        if not description or amount is None:
            return error_response("'description' and 'amount' are required", 400)
        try:
            amount = float(amount)
        except (ValueError, TypeError):
            return error_response("'amount' must be a number", 400)
        group = db.session.get(Group, group_id)
        if not group:
            return error_response("Group not found", 404)
        user_id = get_jwt_identity()
        expense = Expense(
            description=description,
            amount=amount,
            group_id=group_id,
            paid_by=user_id,
        )
        db.session.add(expense)
        db.session.commit()
        return {"id": expense.id}


@expenses_ns.route("/<int:group_id>/expenses/<int:expense_id>")
class ExpenseDetail(Resource):
    @jwt_required()
    @expenses_ns.expect(expense_update_model, validate=True)
    def put(self, group_id, expense_id):
        """Actualiza un gasto existente"""
        data = request.get_json()
        expense = db.session.get(Expense, expense_id)
        if not expense or expense.group_id != group_id:
            return error_response("Expense not found", 404)
        if "description" in data:
            expense.description = data["description"]
        if "amount" in data:
            try:
                expense.amount = float(data["amount"])
            except (ValueError, TypeError):
                return error_response("'amount' must be a number", 400)
        db.session.commit()
        return {"msg": "Expense updated"}

    @jwt_required()
    def delete(self, group_id, expense_id):
        """Elimina un gasto"""
        expense = db.session.get(Expense, expense_id)
        if not expense or expense.group_id != group_id:
            return error_response("Expense not found", 404)
        db.session.delete(expense)
        db.session.commit()
        return {"msg": "Expense deleted"}


# -----------------------------------------------------------
# REGISTRO DE NAMESPACES EN LA API
# -----------------------------------------------------------
api.add_namespace(auth_ns, path="/auth")
api.add_namespace(groups_ns, path="/groups")
api.add_namespace(expenses_ns, path="/groups")

# -----------------------------------------------------------
if __name__ == "__main__":
    with app.app_context():
        db.create_all()
    app.run(debug=True, host="0.0.0.0", port=8001)
