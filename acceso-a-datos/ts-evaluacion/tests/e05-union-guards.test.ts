import { normalizeId, isJwtPayload, requireRole } from "../src/exercises/e05_union_guards";
import { Role, JwtPayload } from "../src/models";

describe("E05 – Union + guards", () => {
  test("normalizeId normaliza string/number", () => {
    expect(normalizeId(10)).toBe("10");
    expect(normalizeId("  x ")).toBe("x");
  });

  test("normalizeId falla si vacío", () => {
    expect(() => normalizeId("   ")).toThrow();
  });

  test("isJwtPayload valida payload", () => {
    expect(isJwtPayload({ sub: "u1", role: "ADMIN", exp: 10 })).toBe(true);
    expect(isJwtPayload({ sub: "", role: "ADMIN", exp: 10 })).toBe(false);
    expect(isJwtPayload(null)).toBe(false);
  });

  test("requireRole valida rol exacto", () => {
    const p: JwtPayload = { sub: "u", role: Role.USER, exp: 1 };
    expect(() => requireRole(p, Role.ADMIN)).toThrow();
  });
});
