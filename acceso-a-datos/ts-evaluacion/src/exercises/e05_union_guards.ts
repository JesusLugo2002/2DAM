import { JwtPayload, Role } from "../models";

/**
 * E05 – Union + type guards (unknown) + JWT
 */

export function normalizeId(id: string | number): string {
  // number => String; string => trim; vacío => Error
  throw new Error("TODO");
}

export function isJwtPayload(value: unknown): value is JwtPayload {
  // objeto no null con sub string no vacía, role USER/ADMIN, exp number finito >=0
  throw new Error("TODO");
}

export function requireRole(payload: JwtPayload, role: Role): void {
  // lanza Error si payload.role != role
  throw new Error("TODO");
}
