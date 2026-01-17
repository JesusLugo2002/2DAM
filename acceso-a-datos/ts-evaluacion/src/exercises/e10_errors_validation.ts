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
  if (value.trim().length == 0) {
    throw new ValidationError(`${fieldName} vacío`);
  }
}

export function parseJson<T>(raw: string): T {
  try {
    return JSON.parse(raw);
  } catch (error) {
    throw new ValidationError("JSON inválido");
  }
}

export function authorize(payload: JwtPayload, allowed: Role[]): void {
  if (!allowed.includes(payload.role)) {
    throw new ValidationError("No autorizado");
  }
}
