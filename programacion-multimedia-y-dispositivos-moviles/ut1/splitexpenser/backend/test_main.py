import re

import pytest

from main import app, db


@pytest.fixture()
def client(tmp_path):
    """Configure a disposable in-memory database for each test."""
    db_path = tmp_path / "test.db"
    app.config.update(
        TESTING=True,
        SQLALCHEMY_DATABASE_URI=f"sqlite:///{db_path}",
        JWT_SECRET_KEY="test-secret-jwt-key",
    )
    with app.app_context():
        db.session.remove()
        db.drop_all()
        db.create_all()
    with app.test_client() as testing_client:
        yield testing_client
    with app.app_context():
        db.session.remove()
        db.drop_all()


def register_user(client, username, password="secret"):
    return client.post(
        "/auth/register",
        json={"username": username, "password": password},
    )


def login_user(client, username, password="secret"):
    response = client.post(
        "/auth/login",
        json={"username": username, "password": password},
    )
    print("Login response data:", response.json)
    assert response.status_code == 200
    assert response.content_type == "application/json"
    payload = response.get_json()
    assert "access_token" in payload
    return payload["access_token"]


def auth_header(token):
    return {"Authorization": f"Bearer {token}"}


def test_register_and_login_flow(client):
    register_response = register_user(client, "alice")
    assert register_response.status_code == 200

    token = login_user(client, "alice")
    assert token
    assert isinstance(token, str)
    # check token is valid JWT format with regular expression
    jwt_pattern = r"^[A-Za-z0-9-_]+\.[A-Za-z0-9-_]+\.[A-Za-z0-9-_]+$"
    assert re.match(jwt_pattern, token)


def test_unregister_user(client):
    register_user(client, "bob")
    token = login_user(client, "bob")
    headers = auth_header(token)
    # Test can login with correct credentials
    login_response = client.post(
        "/auth/login",
        json={"username": "bob", "password": "secret"},
    )
    assert login_response.status_code == 200
    # Unregister with wrong password
    unregister_response = client.post(
        "/auth/unregister",
        headers=headers,
        json={"username": "bob", "password": "unsecret"},
    )
    assert unregister_response.status_code == 401
    unregister_response = client.post(
        "/auth/unregister",
        headers=headers,
        json={"username": "bob", "password": "secret"},
    )
    assert unregister_response.status_code == 200
    # Try to login again
    login_response = client.post(
        "/auth/login",
        json={"username": "bob", "password": "secret"},
    )
    assert login_response.status_code == 401
    assert login_response.get_json()["msg"] == "Bad credentials"


def test_group_management_flow(client):
    register_user(client, "owner")
    owner_token = login_user(client, "owner")
    headers = auth_header(owner_token)

    assert headers["Authorization"].startswith("Bearer ")

    create_group = client.post("/groups", json={"name": "Friends"}, headers=headers)
    assert create_group.status_code == 200
    group_id = create_group.get_json()["id"]

    list_groups = client.get("/groups", headers=headers)
    groups = list_groups.get_json()
    assert list_groups.status_code == 200
    assert len(groups) == 1
    assert groups[0]["name"] == "Friends"

    register_user(client, "new_member")
    add_member = client.post(
        f"/groups/{group_id}",
        headers=headers,
        json={"username": "new_member"},
    )
    assert add_member.status_code == 200

    detail = client.get(f"/groups/{group_id}", headers=headers)
    data = detail.get_json()
    assert detail.status_code == 200
    assert set(data["members"]) == {"owner", "new_member"}


def test_expense_lifecycle(client):
    register_user(client, "spender")
    token = login_user(client, "spender")
    headers = auth_header(token)

    create_group = client.post("/groups", json={"name": "Trip"}, headers=headers)
    group_id = create_group.get_json()["id"]

    create_expense = client.post(
        f"/groups/{group_id}/expenses",
        headers=headers,
        json={"description": "Hotel", "amount": 120.0},
    )
    assert create_expense.status_code == 200
    expense_id = create_expense.get_json()["id"]

    list_expenses = client.get(f"/groups/{group_id}/expenses", headers=headers)
    expenses = list_expenses.get_json()
    assert list_expenses.status_code == 200
    assert len(expenses) == 1
    assert expenses[0]["desc"] == "Hotel"

    update_expense = client.put(
        f"/groups/{group_id}/expenses/{expense_id}",
        headers=headers,
        json={"description": "Hotel x2", "amount": 200},
    )
    assert update_expense.status_code == 200

    list_after_update = client.get(
        f"/groups/{group_id}/expenses", headers=headers
    ).get_json()
    assert list_after_update[0]["desc"] == "Hotel x2"
    assert list_after_update[0]["amount"] == 200.0

    delete_expense = client.delete(
        f"/groups/{group_id}/expenses/{expense_id}", headers=headers
    )
    assert delete_expense.status_code == 200

    final_list = client.get(f"/groups/{group_id}/expenses", headers=headers)
    assert final_list.get_json() == []
