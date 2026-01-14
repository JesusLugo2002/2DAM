/**
 * E01 – Tipos básicos: string/number/boolean/null/undefined
 */

export function normalizeBearer(authHeader: string): string {
  const splittedHeader = authHeader.trim().split(/\s+/);
  if (!splittedHeader[0].toLowerCase().includes("bearer")) {
    throw new Error("Invalid header")
  }
  const normalizedHeader = splittedHeader.join(" ");
  return "B" + normalizedHeader.substring(1);
}

export function clamp01(value: number): number {
  if (Number.isNaN(value) || !Number.isFinite(value)) {
    throw new Error("Valor inválido")
  }
  return Math.max(Math.min(value, 1), 0);
}

export function safeBool(value: boolean | null | undefined): boolean {
  return value == null || value == undefined ? false : value;
}
