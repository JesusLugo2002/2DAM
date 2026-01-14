/**
 * E09 – Async/Promises
 */

export async function delay(ms: number): Promise<void> {
  // resuelve tras ms; Error si ms<0 o no finito
  throw new Error("TODO");
}

export async function retry<T>(fn: () => Promise<T>, attempts: number): Promise<T> {
  // reintenta attempts veces; si resuelve devuelve; si falla siempre lanza último error
  throw new Error("TODO");
}

export async function parallelSum(values: Array<Promise<number>>): Promise<number> {
  // Promise.all y suma; Error si alguno no es finito
  throw new Error("TODO");
}
