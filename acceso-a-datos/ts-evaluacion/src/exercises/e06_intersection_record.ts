import { Task } from "../models";

/**
 * E06 – Intersection + Record
 */

export type AdminTask = Task & { adminOnly: true };

export function makeAdminTask(task: Task): AdminTask {
  // devuelve task + adminOnly=true (sin mutar task original)
  throw new Error("TODO");
}

export function buildAuthHeaders(token: string): Record<string, string> {
  // { Authorization: "Bearer <token>", "Content-Type": "application/json" } token trim no vacío
  throw new Error("TODO");
}

export function groupByCompleted(tasks: Task[]): Record<"done" | "pending", Task[]> {
  // retorna { done: [...], pending: [...] } (arrays nuevos)
  throw new Error("TODO");
}
