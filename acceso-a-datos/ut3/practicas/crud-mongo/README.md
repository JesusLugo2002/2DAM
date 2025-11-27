# Personas Mongo CRUD

Proyecto de ejemplo con **Spring Boot (JDK 17)** + **MongoDB** para hacer un CRUD
de un objeto `Persona` que contiene una `Direccion` embebida.

Incluye:

- API REST para operaciones CRUD.
- Búsquedas personalizadas (por nombre, ciudad, rango de edad, dominio de email, etc.).
- `docker-compose` para levantar:
  - una base de datos MongoDB
  - un cliente web Mongo (mongo-express) para visualizar la BBDD.

---

## 1. Requisitos

- Java 17
- Maven 3.x
- Docker y Docker Compose

---

## 2. Levantar MongoDB y el cliente web

Desde la raíz del proyecto:

```bash
docker-compose up -d
```

Esto arranca:

- MongoDB en `localhost:27017`
- mongo-express en `http://localhost:8081`

Credenciales definidas en `docker-compose.yml`:

- Usuario Mongo: `root`
- Password Mongo: `rootpassword`
- BBDD por defecto: `personas_db`

Para mongo-express (interfaz web):

- Usuario: `admin`
- Password: `admin`

Puedes comprobar la BBDD en:

- Navegador → `http://localhost:8081`

---

## 3. Configuración de Spring Boot

En `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://root:rootpassword@localhost:27017/personas_db?authSource=admin
```

Si cambias usuario/contraseña en `docker-compose.yml`, actualiza también la URI.

---

## 4. Arrancar la aplicación

```bash
mvn spring-boot:run
```

La API REST quedará disponible en:

- `http://localhost:8080/api/personas`

---

## 5. Modelo de datos

### Persona

```json
{
  "id": "generado_por_mongo",
  "nombre": "Ana",
  "edad": 25,
  "email": "ana@example.com",
  "direccion": {
    "calle": "Calle Mayor 1",
    "ciudad": "Madrid",
    "codigoPostal": "28001",
    "pais": "España"
  }
}
```

---

## 6. Endpoints CRUD principales

### Crear persona

```bash
POST http://localhost:8080/api/personas
Content-Type: application/json

{
  "nombre": "Juan",
  "edad": 30,
  "email": "juan@example.com",
  "direccion": {
    "calle": "Gran Vía 123",
    "ciudad": "Madrid",
    "codigoPostal": "28013",
    "pais": "España"
  }
}
```

### Listar todas

```bash
GET http://localhost:8080/api/personas
```

### Obtener por ID

```bash
GET http://localhost:8080/api/personas/{id}
```

### Actualizar

```bash
PUT http://localhost:8080/api/personas/{id}
Content-Type: application/json

{
  "nombre": "Juan Actualizado",
  "edad": 31,
  "email": "juan.actualizado@example.com",
  "direccion": {
    "calle": "Gran Vía 999",
    "ciudad": "Madrid",
    "codigoPostal": "28013",
    "pais": "España"
  }
}
```

### Borrar

```bash
DELETE http://localhost:8080/api/personas/{id}
```

---

## 7. Búsquedas personalizadas

### 7.1 Buscar por nombre (contiene, case-insensitive)

```bash
GET "http://localhost:8080/api/personas/buscar/nombre?nombre=an"
```

### 7.2 Buscar por ciudad

```bash
GET "http://localhost:8080/api/personas/buscar/ciudad?ciudad=Madrid"
```

### 7.3 Buscar por rango de edad

```bash
GET "http://localhost:8080/api/personas/buscar/edad-rango?min=18&max=30"
```

### 7.4 Buscar por edad mínima

```bash
GET "http://localhost:8080/api/personas/buscar/edad-minima?edad=40"
```

### 7.5 Buscar por email exacto

```bash
GET "http://localhost:8080/api/personas/buscar/email?email=juan@example.com"
```

### 7.6 Buscar por dominio de email (regex)

```bash
GET "http://localhost:8080/api/personas/buscar/email-dominio?dominio=@gmail.com"
```

---

## 8. Apagar los servicios

```bash
docker-compose down
```

(Usa `docker-compose down -v` si también quieres borrar los volúmenes de datos.)
