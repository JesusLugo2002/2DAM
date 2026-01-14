import { first, unique, groupBy } from "../src/exercises/e08_generics";

describe("E08 – Genéricos", () => {
  test("first devuelve primer elemento", () => {
    expect(first([1,2,3])).toBe(1);
  });

  test("first lanza error si vacío", () => {
    expect(() => first([] as number[])).toThrow();
  });

  test("unique elimina duplicados preservando orden", () => {
    expect(unique([1,1,2,1,3])).toEqual([1,2,3]);
  });

  test("groupBy agrupa correctamente", () => {
    const r = groupBy(["aa","ab","b"], s => s[0] as "a"|"b");
    expect(r.a).toEqual(["aa","ab"]);
    expect(r.b).toEqual(["b"]);
  });
});
