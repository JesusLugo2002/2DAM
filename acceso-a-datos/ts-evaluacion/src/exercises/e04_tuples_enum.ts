import { Role } from "../models";

/**
 * E04 – Tuples y enum
 */

export type JwtParts = [header: string, payload: string, signature: string];

export function splitJwt(token: string): JwtParts {
  const parts = token.split(".");
  if (parts.length != 3) {
    throw new Error("Invalid token");
  }
  return parts as JwtParts;
}

export function roleFromString(value: string): Role {
  // "ADMIN"|"USER" (case-insensitive) => Role; si no => Error
  const normalizedValue = value.toUpperCase().trim();
  if (normalizedValue == Role.ADMIN || normalizedValue == Role.USER) {
    throw new Error("Invalid role");
  }
  return normalizedValue as Role;
}

export function formatUserTag(username: string, role: Role): string {
  // "juan", ADMIN => "juan#ADMIN" (username trim, no vacío)
  throw new Error("TODO");
}
