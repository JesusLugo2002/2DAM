import { isValidISODate, nightsBetween, toIsoDateOnly } from "../src/exercises/e02_date";

describe("E02 – Date", () => {
  test("isValidISODate acepta válidas y rechaza inválidas", () => {
    expect(isValidISODate("2026-01-14")).toBe(true);
    expect(isValidISODate("2026-02-30")).toBe(false);
    expect(isValidISODate("2026-1-01")).toBe(false);
  });

  test("nightsBetween calcula noches", () => {
    expect(nightsBetween("2026-01-10", "2026-01-13")).toBe(3);
  });

  test("nightsBetween lanza error si salida<=entrada o inválida", () => {
    expect(() => nightsBetween("2026-01-10", "2026-01-10")).toThrow();
    expect(() => nightsBetween("nope", "2026-01-13")).toThrow();
  });

  test("toIsoDateOnly genera YYYY-MM-DD", () => {
    expect(toIsoDateOnly(new Date("2026-03-05T10:00:00.000Z"))).toBe("2026-03-05");
  });
});
