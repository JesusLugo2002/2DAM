/**
 * E08 – Genéricos
 */

export function first<T>(items: T[]): T {
  // devuelve primer elemento, Error si vacío
  throw new Error("TODO");
}

export function unique<T>(items: T[]): T[] {
  // devuelve array sin duplicados preservando orden (usa Set internamente)
  throw new Error("TODO");
}

export function groupBy<T, K extends string | number>(items: T[], keyFn: (item: T) => K): Record<K, T[]> {
  // agrupa por clave y devuelve Record (arrays nuevos)
  throw new Error("TODO");
}
