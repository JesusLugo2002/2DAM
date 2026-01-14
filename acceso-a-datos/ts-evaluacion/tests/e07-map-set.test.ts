import { indexTasksById, uniqueRoles, touchSession } from "../src/exercises/e07_map_set";
import { Role, Task } from "../src/models";

describe("E07 – Map/Set", () => {
  test("indexTasksById: última gana", () => {
    const tasks: Task[] = [
      { id: "1", title: "A", completed: false, createdAt: new Date("2026-01-01") },
      { id: "1", title: "B", completed: true, createdAt: new Date("2026-01-02") }
    ];
    const m = indexTasksById(tasks);
    expect(m.get("1")?.title).toBe("B");
  });

  test("uniqueRoles elimina duplicados", () => {
    const s = uniqueRoles([Role.USER, Role.USER, Role.ADMIN]);
    expect(s.size).toBe(2);
    expect(s.has(Role.ADMIN)).toBe(true);
  });

  test("touchSession devuelve previo y actualiza", () => {
    const sessions = new Map<string, Date>();
    const d1 = new Date("2026-01-01T00:00:00Z");
    const d2 = new Date("2026-01-02T00:00:00Z");
    expect(touchSession(sessions, "t", d1)).toBeUndefined();
    expect(sessions.get("t")?.toISOString()).toBe(d1.toISOString());
    const prev = touchSession(sessions, "t", d2);
    expect(prev?.toISOString()).toBe(d1.toISOString());
    expect(sessions.get("t")?.toISOString()).toBe(d2.toISOString());
  });
});
