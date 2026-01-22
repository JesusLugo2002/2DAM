# Ejercicio: Servicio REST de Eventos con aprobación y seguridad JWT

Este proyecto es una **plantilla** (Spring Boot + Maven). La aplicación arranca y expone endpoints, la autenticación JWT está preparada y la configuración está externalizada en `application.properties`, pero la **lógica de negocio del dominio** (reglas de eventos) está **sin implementar** a propósito.

Tu trabajo consiste en:

1) Implementar las **reglas de negocio** del dominio (aprobación, visibilidad, ownership, transiciones de estado, permisos).
2) Asegurar que la **API pública (v1)** solo devuelve eventos **APPROVED**.
3) Completar el comportamiento de la **API protegida (v2)** según el rol (`COLLABORATOR` / `ADMIN`) y según los **flags de permisos** configurados.


<div align="center">
    <img src=images/reglas.png width="400">
</div>

---

## 1) Arranque rápido

### Requisitos
- Java 17+
- Maven 3.9+

### Ejecutar
```bash
mvn clean spring-boot:run
```

Swagger (OpenAPI):
- `http://localhost:8080/swagger-ui.html`

---

## 2) Configuración externalizada 

Fichero:
- `src/main/resources/application.properties`

Se usa para configurar:

### 2.1 Rutas públicas/protegidas

Claves:
- `app.security.routes.public[...]`
- `app.security.routes.protected[...]`

Implementación ya hecha en:
- `com.docencia.aed.infrastructure.security.SecurityConfig`

### 2.2 Usuarios y roles
Claves:
- `app.security.users[0].username`, `.password`, `.roles[...]`, etc.

Implementación ya hecha (usuarios en memoria) en:
- `com.docencia.aed.infrastructure.security.SecurityConfig#userDetailsService`

### 2.3 Permisos por rol (flags)
Claves:
- `app.security.permissions.collaborator.*`
- `app.security.permissions.admin.*`

**Obligatorio**: tu lógica de negocio debe respetar estos flags.

> Ejemplo: aunque un usuario tenga rol `COLLABORATOR`, si `app.security.permissions.collaborator.canSubmitForApproval=false`, entonces `/api/v2/events/{id}/submit` debe devolver **403**.

Propiedades mapeadas en:
- `com.docencia.aed.infrastructure.security.AppSecurityProperties`

---

## 3) Modelo de dominio

Entidades:
- `com.docencia.aed.entity.Event`
- `com.docencia.aed.entity.EventStatus`

Estados mínimos:
- `DRAFT`
- `PENDING_APPROVAL`
- `APPROVED`
- `REJECTED`

BBDD en memoria:
- `com.docencia.aed.repository.memory.InMemoryEventRepository`

Seed inicial:
- `com.docencia.aed.repository.memory.SeedData`

---

## 4) Endpoints del servicio

### 4.1 Auth
Controlador:
- `com.docencia.aed.controller.AuthController`

- `POST /api/auth/login`
  - body: `{ "username": "collab", "password": "collab123" }`
  - respuesta: `{ "token": "..." }`

> Nota: el login y el JWT ya están implementados en `JwtService` + `JwtAuthenticationFilter`.

### 4.2 API pública v1 (sin token)
Controlador:
- `com.docencia.aed.controller.PublicEventController`

- `GET /api/v1/events`
  - Debe devolver **solo** eventos con `status=APPROVED`.

- `GET /api/v1/events/{id}`
  - Debe devolver el evento **solo** si `status=APPROVED`.
  - Si existe pero NO está aprobado → **404** (para no filtrar borradores o pendientes).

### 4.3 API protegida v2 (con token JWT)
Controlador:
- `com.docencia.aed.controller.EventControllerV2`

- `GET /api/v2/events?status=...` (query param opcional)
- `GET /api/v2/events/{id}`
- `POST /api/v2/events`
- `PATCH /api/v2/events/{id}`
- `POST /api/v2/events/{id}/submit`
- `POST /api/v2/events/{id}/approve`
- `POST /api/v2/events/{id}/reject` body: `{ "reason": "..." }`
- `DELETE /api/v2/events/{id}`

---

## 5) DÓNDE debes implementar (ficheros a tocar)

### 5.1 Implementación principal (OBLIGATORIO)
Archivo:
- `src/main/java/com/docencia/aed/service/impl/EventServiceImpl.java`

Aquí están los métodos con `UnsupportedOperationException("TODO: implementar")`.

Debes implementar:
- `listPublicApproved()`
- `getPublicApprovedById(Long id)`
- `listV2(String requestingUser, boolean isAdmin, EventStatus statusFilterOrNull)`
- `getV2ById(String requestingUser, boolean isAdmin, Long id)`
- `create(String requestingUser, boolean isAdmin, EventCreateRequest req)`
- `patch(String requestingUser, boolean isAdmin, Long id, EventPatchRequest req)`
- `submitForApproval(String requestingUser, boolean isAdmin, Long id)`
- `approve(String requestingUser, boolean isAdmin, Long id)`
- `reject(String requestingUser, boolean isAdmin, Long id, String reason)`
- `delete(String requestingUser, boolean isAdmin, Long id)`

### 5.2 Leer y aplicar permisos desde configuración (OBLIGATORIO)

Debes usar `AppSecurityProperties` dentro del servicio para decidir si una acción está permitida.

Sugerencia:
- Inyecta `AppSecurityProperties` en `EventServiceImpl`.
- Crea un método privado que obtenga los permisos efectivos según rol:
  - si `isAdmin=true` → usar `props.getPermissions().getAdmin()`
  - si `isAdmin=false` → usar `props.getPermissions().getCollaborator()`

---

## 6) Reglas de negocio (OBLIGATORIAS)

### 6.1 Visibilidad pública (v1)
- v1 **solo devuelve** eventos `APPROVED`.
- En `GET /api/v1/events/{id}`:
  - si no está `APPROVED` → **404**.

### 6.2 Visibilidad v2
- ADMIN ve todos.
- COLLABORATOR ve **solo sus eventos** (`event.createdBy == requestingUser`).

### 6.3 Ownership y permisos (COLLABORATOR)
El colaborador:
- Puede **crear** si `permissions.collaborator.canCreate=true`.
- Puede **editar** solo si:
  - `permissions.collaborator.canEditOwnDraftOrRejected=true`
  - el evento es suyo
  - y el estado es `DRAFT` o `REJECTED`
- Puede **submit** solo si:
  - `permissions.collaborator.canSubmitForApproval=true`
  - el evento es suyo
  - y el estado es `DRAFT` o `REJECTED`
- No puede `approve`, `reject`, `delete` (salvo que lo habilites explícitamente por flags, pero por defecto deben ser **403**).

### 6.4 Permisos ADMIN
El admin:
- Puede hacer todo según flags `permissions.admin.*`.
- En particular:
  - `approve/reject` solo debe aplicarse si el estado es `PENDING_APPROVAL`.

### 6.5 Transiciones de estado
Transiciones válidas:
- `DRAFT` → `PENDING_APPROVAL` (submit)
- `REJECTED` → `PENDING_APPROVAL` (submit)
- `PENDING_APPROVAL` → `APPROVED` (approve)
- `PENDING_APPROVAL` → `REJECTED` (reject)

Transiciones inválidas deben devolver **409 Conflict** (o **403** si prefieres tratarlo como “no permitido”; elige un criterio y mantenlo consistente).

### 6.6 Borrado
- `DELETE` solo ADMIN si `permissions.admin.canDelete=true`.

---

## 7) Manejo de errores (ya hay infraestructura)

Excepciones existentes:
- `com.docencia.aed.exception.ResourceNotFoundException` → 404
- `com.docencia.aed.exception.BadRequestException` → 400
- `com.docencia.aed.exception.ForbiddenException` → 403

Y handler global:
- `com.docencia.aed.exception.GlobalExceptionHandler`

Sugerencia:
- Usa `ResourceNotFoundException` cuando el evento no exista (o cuando v1 intente acceder a no aprobado).
- Usa `ForbiddenException` cuando el usuario esté autenticado pero no tenga permiso.
- Usa `BadRequestException` para payloads inválidos (si necesitas validación extra).
- Para conflictos de estado, puedes:
  - reutilizar `BadRequestException`, o
  - crear `ConflictException` (opcional) y mapearla a 409.

---

## 8) Checklist de implementación (paso a paso)

1. **Lee el código** de `EventControllerV2` y `PublicEventController` para entender qué llama cada endpoint.
2. Implementa **primero** `listPublicApproved()` y `getPublicApprovedById()`.
3. Implementa `listV2()` y `getV2ById()` aplicando visibilidad por rol (admin vs collaborator).
4. Implementa `create()`:
   - debe crear evento en `DRAFT`
   - `createdBy = requestingUser`
   - respetar `permissions.*.canCreate`
5. Implementa `patch()`:
   - collaborator: solo suyos + `DRAFT/REJECTED`
   - admin: según flag `canEditAny`
6. Implementa `submitForApproval()`:
   - validar permisos
   - validar transición de estado
7. Implementa `approve()` y `reject()`:
   - solo admin con flags
   - solo desde `PENDING_APPROVAL`
   - `reject` debe guardar motivo
8. Implementa `delete()`:
   - solo admin con flag

---

## 9) Pruebas manuales rápidas (curl)

### 9.1 Login colaborador
```bash
TOKEN=$(curl -s -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"collab","password":"collab123"}' | jq -r .token)
```

### 9.2 Crear evento (v2)
```bash
curl -s -X POST http://localhost:8080/api/v2/events \
  -H "Authorization: Bearer $TOKEN" \
  -H 'Content-Type: application/json' \
  -d '{"title":"Mi evento","description":"desc","startAt":"2026-02-01T10:00:00Z","location":"Aula"}'
```

### 9.3 Submit
```bash
curl -s -X POST http://localhost:8080/api/v2/events/1/submit \
  -H "Authorization: Bearer $TOKEN"
```

### 9.4 Login admin + approve
```bash
ADMIN=$(curl -s -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"admin","password":"admin123"}' | jq -r .token)

curl -s -X POST http://localhost:8080/api/v2/events/1/approve \
  -H "Authorization: Bearer $ADMIN"
```

### 9.5 Ver en v1 (público)
```bash
curl -s http://localhost:8080/api/v1/events
```

---

## 10) Criterios de evaluación (orientativo)

- Cumplimiento de reglas (visibilidad, ownership, estados).
- Uso real de configuración externalizada (`AppSecurityProperties.permissions`).
- Respuestas HTTP coherentes (401/403/404/409).
- Código limpio (métodos pequeños, validaciones claras).

MD