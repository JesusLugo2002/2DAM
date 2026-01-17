# Evaluación · TypeScript

Este proyecto sirve para **verificar el conocimiento** de los conceptos del tema:
tipos básicos, Date, arrays, tuples, enums, unions, type guards, intersection, Record/Map/Set, genéricos, async/promises y validación de errores.

---

## Requisitos
- Node.js 20+
- npm

## Instalación
```bash
npm install
```

## Ejecutar tests
```bash
npm test
```

## Lanzar un fichero de test concreto
```bash
npx jest tests/e01-basicos.test.ts
```

Al finalizar la ejecución de los tests se generan automáticamente:
- `nota/nota.json`
- `nota/nota.txt`

---

## Cómo se calcula la nota
Cada ejercicio corresponde a un fichero de tests y tiene un **peso (dificultad)**.
La puntuación por ejercicio es proporcional al número de tests aprobados.

Pesos (suma ≈ 12.0):
- **E01** básicos: 1.0  
- **E02** Date: 1.0  
- **E03** Arrays: 1.0  
- **E04** Tuples / enum: 1.0  
- **E05** Union / guards: 1.2  
- **E06** Intersection / Record: 1.2  
- **E07** Map / Set: 1.2  
- **E08** Genéricos: 1.4  
- **E09** Async / Promises: 1.5  
- **E10** Errores / Validación: 1.5  

**Nota final (0..10)** = media ponderada por dificultad.

---

# Qué tienes que implementar

Todos los ejercicios están en `src/exercises/`.  
Inicialmente, **todas las funciones lanzan `Error("TODO")`** y debes implementar su lógica para pasar los tests.

---

## E01 – Tipos básicos
**Fichero:** `src/exercises/e01_basicos.ts`  
**Conceptos:** string, number, boolean, null/undefined

Funciones:
- `normalizeBearer(authHeader: string): string`  
  Normaliza un header `Authorization` (`Bearer <token>`), validando esquema, espacios y token.
- `clamp01(value: number): number`  
  Limita un número al rango `[0,1]`, error si no es finito.
- `safeBool(value: boolean | null | undefined): boolean`  
  Convierte valores opcionales a boolean seguro.

---

## E02 – Date
**Fichero:** `src/exercises/e02_date.ts`  
**Conceptos:** fechas ISO, UTC, validación

Funciones:
- `isValidISODate(iso: string): boolean`  
  Valida fechas `YYYY-MM-DD` estrictas.
- `nightsBetween(entrada: string, salida: string): number`  
  Calcula noches entre dos fechas ISO.
- `toIsoDateOnly(date: Date): string`  
  Convierte un `Date` a `YYYY-MM-DD` (UTC).

---

## E03 – Arrays
**Fichero:** `src/exercises/e03_arrays.ts`  
**Conceptos:** filter, map, reduce, sort (sin mutar)

Funciones:
- `pendingTasks(tasks: Task[]): Task[]`
- `titlesSorted(tasks: Task[]): string[]`
- `completionPercent(tasks: Task[]): number`

---

## E04 – Tuples y Enum
**Fichero:** `src/exercises/e04_tuples_enum.ts`

Funciones:
- `splitJwt(token: string): JwtParts`  
  Divide un JWT en tupla `[header, payload, signature]`.
- `roleFromString(value: string): Role`  
  Convierte string a enum `Role` (case-insensitive).
- `formatUserTag(username: string, role: Role): string`  
  Devuelve `"usuario#ROL"`.

---

## E05 – Union y Type Guards
**Fichero:** `src/exercises/e05_union_guards.ts`

Funciones:
- `normalizeId(id: string | number): string`
- `isJwtPayload(value: unknown): value is JwtPayload`
- `requireRole(payload: JwtPayload, role: Role): void`

---

## E06 – Intersection y Record
**Fichero:** `src/exercises/e06_intersection_record.ts`

Funciones:
- `makeAdminTask(task: Task): AdminTask`
- `buildAuthHeaders(token: string): Record<string, string>`
- `groupByCompleted(tasks: Task[]): Record<"done" | "pending", Task[]>`

---

## E07 – Map y Set
**Fichero:** `src/exercises/e07_map_set.ts`

Funciones:
- `indexTasksById(tasks: Task[]): Map<string, Task>`
- `uniqueRoles(roles: Role[]): Set<Role>`
- `touchSession(sessions: Map<string, Date>, token: string, now: Date): Date | undefined`

---

## E08 – Genéricos
**Fichero:** `src/exercises/e08_generics.ts`

Funciones:
- `first<T>(items: T[]): T`
- `unique<T>(items: T[]): T[]`
- `groupBy<T, K extends string | number>(items: T[], keyFn: (item:T)=>K): Record<K, T[]>`

---

## E09 – Async / Promises
**Fichero:** `src/exercises/e09_async_promises.ts`

Funciones:
- `delay(ms: number): Promise<void>`
- `retry<T>(fn: () => Promise<T>, attempts: number): Promise<T>`
- `parallelSum(values: Array<Promise<number>>): Promise<number>`

---

## E10 – Errores y Validación
**Fichero:** `src/exercises/e10_errors_validation.ts`

Componentes:
- Clase `ValidationError`

Funciones:
- `assertNonEmpty(value: string, fieldName: string): void`
- `parseJson<T>(raw: string): T`
- `authorize(payload: JwtPayload, allowed: Role[]): void`

---

## Consejos generales
- Usa TypeScript en modo **strict**.
- Evita `any`; prefiere `unknown` + type guards.
- No mutes datos de entrada salvo que se indique.
- Implementa primero el caso correcto y luego los errores.
