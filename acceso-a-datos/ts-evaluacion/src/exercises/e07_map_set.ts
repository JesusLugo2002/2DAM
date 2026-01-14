import { Role, Task } from "../models";

/**
 * E07 – Map / Set
 */

export function indexTasksById(tasks: Task[]): Map<string, Task> {
  // key=id, value=task (última gana si repetido)
  throw new Error("TODO");
}

export function uniqueRoles(roles: Role[]): Set<Role> {
  // devuelve Set sin duplicados
  throw new Error("TODO");
}

export function touchSession(sessions: Map<string, Date>, token: string, now: Date): Date | undefined {
  // devuelve fecha previa si existía y actualiza token->now
  throw new Error("TODO");
}
