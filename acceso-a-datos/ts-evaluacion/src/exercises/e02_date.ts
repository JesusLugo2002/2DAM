/**
 * E02 – Date: parseo YYYY-MM-DD, validación y diferencias en días.
 */

export function isValidISODate(iso: string): boolean {
  // regex yyyy-mm-dd + Date válida + conserva componentes (evita 2026-02-30)
  throw new Error("TODO");
}

export function nightsBetween(entrada: string, salida: string): number {
  // intervalo [entrada, salida) => noches. Error si salida<=entrada o fechas inválidas
  throw new Error("TODO");
}

export function toIsoDateOnly(date: Date): string {
  // "YYYY-MM-DD" desde Date (UTC). Error si date inválida.
  throw new Error("TODO");
}
