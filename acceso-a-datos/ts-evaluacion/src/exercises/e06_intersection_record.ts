import { Task } from "../models";

/**
 * E06 – Intersection + Record
 */

export type AdminTask = Task & { adminOnly: true };

export function makeAdminTask(task: Task): AdminTask {
  return Object.assign({ adminOnly: true }, task) as AdminTask;
}

export function buildAuthHeaders(token: string): Record<string, string> {
  return { Authorization: "Bearer " + token.trim(), "Content-Type": "application/json" }
}

export function groupByCompleted(tasks: Task[]): Record<"done" | "pending", Task[]> {
  const result: Record<"done" | "pending", Task[]> = {
    "done": [], "pending": []
  }
  tasks.forEach((task) => {
    if (task.completed) {
      result.done.push(task)
    } else {
      result.pending.push(task)
    }
  })
  return result;
}
