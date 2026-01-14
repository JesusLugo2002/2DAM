import { Task } from "../models";

/**
 * E03 – Arrays: filter/map/reduce/sort sin mutar original
 */

export function pendingTasks(tasks: Task[]): Task[] {
  return tasks.filter((task) => !task.completed);
}

export function titlesSorted(tasks: Task[]): string[] {
  const sortedTasks = tasks.slice().sort((a, b) => a.title.localeCompare(b.title));
  return sortedTasks.map((task) => task.title);
}

export function completionPercent(tasks: Task[]): number {
  const tasksLength = tasks.length;
  if (tasksLength == 0) {
    return 0;
  }
  let completed = 0;
  tasks.forEach((task) => {
    if (task.completed) {
      completed++;
    }
  });
  return Math.round(completed * 100 / tasksLength);
}
