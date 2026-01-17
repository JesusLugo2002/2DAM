import { Role, Task } from "../models";

/**
 * E07 – Map / Set
 */

export function indexTasksById(tasks: Task[]): Map<string, Task> {
  const result = new Map();
  tasks.forEach((task) => result.set(task.id, task));
  return result;
}

export function uniqueRoles(roles: Role[]): Set<Role> {
  return new Set(roles);
}

export function touchSession(
  sessions: Map<string, Date>,
  token: string,
  now: Date
): Date | undefined {
  const previous = sessions.get(token);
  sessions.set(token, now);
  return previous;
}
