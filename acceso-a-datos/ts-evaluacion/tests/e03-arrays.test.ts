import { pendingTasks, titlesSorted, completionPercent } from "../src/exercises/e03_arrays";
import { Task } from "../src/models";

const t = (id: string, title: string, completed: boolean): Task => ({ id, title, completed, createdAt: new Date("2026-01-01") });

describe("E03 – Arrays", () => {
  test("pendingTasks devuelve solo pendientes", () => {
    const tasks = [t("1","A",true), t("2","B",false), t("3","C",false)];
    expect(pendingTasks(tasks).map(x => x.id)).toEqual(["2","3"]);
  });

  test("titlesSorted ordena títulos sin mutar", () => {
    const tasks = [t("1","b",false), t("2","a",true)];
    const original = [...tasks];
    expect(titlesSorted(tasks)).toEqual(["a","b"]);
    expect(tasks).toEqual(original);
  });

  test("completionPercent calcula porcentaje", () => {
    expect(completionPercent([])).toBe(0);
    expect(completionPercent([t("1","A",true), t("2","B",false)])).toBe(50);
  });
});
