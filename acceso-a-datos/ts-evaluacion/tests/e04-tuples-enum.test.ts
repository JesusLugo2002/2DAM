import { splitJwt, roleFromString, formatUserTag } from "../src/exercises/e04_tuples_enum";
import { Role } from "../src/models";

describe("E04 – Tuples + enum", () => {
  test("splitJwt separa token", () => {
    expect(splitJwt("a.b.c")).toEqual(["a","b","c"]);
  });

  test("splitJwt falla si no hay 3 partes", () => {
    expect(() => splitJwt("a.b")).toThrow();
    expect(() => splitJwt("a.b.c.d")).toThrow();
  });

  test("roleFromString es case-insensitive", () => {
    expect(roleFromString("admin")).toBe(Role.ADMIN);
    expect(roleFromString("USER")).toBe(Role.USER);
    expect(() => roleFromString("NOPE")).toThrow();
  });

  test("formatUserTag valida username", () => {
    expect(formatUserTag("  ana ", Role.USER)).toBe("ana#USER");
    expect(() => formatUserTag("   ", Role.ADMIN)).toThrow();
  });
});
