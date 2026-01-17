import { makeAdminTask, buildAuthHeaders, groupByCompleted } from "../src/exercises/e06_intersection_record";
import { Task } from "../src/models";

const t = (id: string, completed: boolean): Task => ({ id, title: id, completed, createdAt: new Date("2026-01-01") });

describe("E06 – Intersection + Record", () => {
  test("makeAdminTask añade adminOnly", () => {
    const base: Task = t("1", false);
    const admin = makeAdminTask(base);
    expect(admin.adminOnly).toBe(true);
    expect((base as any).adminOnly).toBeUndefined(); // no muta original
  });

  test("buildAuthHeaders construye headers", () => {
    expect(buildAuthHeaders("  tok ")).toEqual({
      Authorization: "Bearer tok",
      "Content-Type": "application/json"
    });
  });

  test("groupByCompleted separa done/pending", () => {
    const g = groupByCompleted([t("1", true), t("2", false), t("3", true)]);
    expect(g.done.map(x => x.id)).toEqual(["1","3"]);
    expect(g.pending.map(x => x.id)).toEqual(["2"]);
  });
});
