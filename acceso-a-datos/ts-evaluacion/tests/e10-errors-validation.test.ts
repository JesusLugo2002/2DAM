import { ValidationError, assertNonEmpty, parseJson, authorize } from "../src/exercises/e10_errors_validation";
import { Role, JwtPayload } from "../src/models";

describe("E10 – Errors + validation", () => {
  test("assertNonEmpty lanza ValidationError si vacío", () => {
    expect(() => assertNonEmpty("   ", "title")).toThrow(ValidationError);
  });

  test("assertNonEmpty no lanza si válido", () => {
    expect(() => assertNonEmpty("hola", "title")).not.toThrow();
  });

  test("parseJson parsea y tipa", () => {
    const obj = parseJson<{ a: number }>('{"a":1}');
    expect(obj.a).toBe(1);
  });

  test("parseJson lanza ValidationError si inválido", () => {
    expect(() => parseJson("{nope")).toThrow(ValidationError);
  });

  test("authorize valida allowed roles", () => {
    const p: JwtPayload = { sub: "u", role: Role.USER, exp: 10 };
    expect(() => authorize(p, [Role.ADMIN])).toThrow(ValidationError);
    expect(() => authorize(p, [Role.ADMIN, Role.USER])).not.toThrow();
  });
});
