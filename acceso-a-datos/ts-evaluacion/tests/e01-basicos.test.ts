import { normalizeBearer, clamp01, safeBool } from "../src/exercises/e01_basicos";

describe("E01 – Tipos básicos", () => {
  test("normalizeBearer normaliza espacios y casing", () => {
    expect(normalizeBearer("  bearer   abc.def ")).toBe("Bearer abc.def");
  });

  test("normalizeBearer lanza error si no es Bearer", () => {
    expect(() => normalizeBearer("Basic 123")).toThrow();
    expect(() => normalizeBearer("")).toThrow();
  });

  test("clamp01 limita correctamente", () => {
    expect(clamp01(-1)).toBe(0);
    expect(clamp01(0.5)).toBe(0.5);
    expect(clamp01(2)).toBe(1);
  });

  test("clamp01 lanza error en NaN o infinito", () => {
    expect(() => clamp01(Number.NaN)).toThrow();
    expect(() => clamp01(Number.POSITIVE_INFINITY)).toThrow();
  });

  test("safeBool maneja null/undefined", () => {
    expect(safeBool(undefined)).toBe(false);
    expect(safeBool(null)).toBe(false);
    expect(safeBool(true)).toBe(true);
  });
});
