import { JwtPayload, Role } from "../models";

/**
 * E10 – Errores típicos + validación de entradas (académico)
 */

export class ValidationError extends Error {
  constructor(message: string) {
    super(message);
    this.name = "ValidationError";
  }
}

export function assertNonEmpty(value: string, fieldName: string): void {
  // si value.trim() vacío => throw ValidationError(`${fieldName} vacío`)
  throw new Error("TODO");
}

export function parseJson<T>(raw: string): T {
  // JSON.parse + si falla => throw ValidationError("JSON inválido")
  throw new Error("TODO");
}

export function authorize(payload: JwtPayload, allowed: Role[]): void {
  // si payload.role no está en allowed => throw ValidationError("No autorizado")
  throw new Error("TODO");
}
