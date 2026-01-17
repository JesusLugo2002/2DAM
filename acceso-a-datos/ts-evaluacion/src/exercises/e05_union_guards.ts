import { JwtPayload, Role } from "../models";

/**
 * E05 – Union + type guards (unknown) + JWT
 */

export function normalizeId(id: string | number): string {
  if (typeof id == "number") {
    return id.toString();
  }
  const trimmedValue = id.trim();
  if (trimmedValue.length == 0) {
    throw new Error("Empty id");
  }
  return trimmedValue;
}

export function isJwtPayload(value: unknown): value is JwtPayload {
  return (
    typeof value === "object" &&
    value !== null &&
    "sub" in value &&
    "role" in value &&
    "exp" in value &&
    typeof (value as JwtPayload).sub === "string" &&
    (value as JwtPayload).sub.trim().length > 0 &&
    typeof (value as JwtPayload).role === "string" &&
    (value as JwtPayload).role.trim() in Role &&
    typeof (value as JwtPayload).exp === "number" &&
    (value as JwtPayload).exp >= 0
  );
}

export function requireRole(payload: JwtPayload, role: Role): void {
  if (payload.role != role) {
    throw new Error("Not have the required role!");
  }
}
