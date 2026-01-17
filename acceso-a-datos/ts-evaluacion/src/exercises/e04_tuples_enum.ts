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
  const normalizedValue = value.toUpperCase().trim();
  if (!Object.values(Role).includes(normalizedValue as Role)) {
    throw new Error("Invalid role");
  }
  return normalizedValue as Role;
}

export function formatUserTag(username: string, role: Role): string {
  // "juan", ADMIN => "juan#ADMIN" (username trim, no vacío)
  const trimmedUsername = username.trim();
  if (trimmedUsername.length == 0) {
    throw new Error("Empty username")
  }
  return trimmedUsername + "#" + role.toUpperCase();
}
