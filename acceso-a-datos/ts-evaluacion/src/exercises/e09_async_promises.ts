/**
 * E09 – Async/Promises
 */

export async function delay(ms: number): Promise<void> {
  if (!isFinite(ms) || ms < 0) {
    throw new Error("Ms is zero or not finite");
  }
  return new Promise(resolve => setTimeout(resolve, ms))
}

export async function retry<T>(fn: () => Promise<T>, attempts: number): Promise<T> {
  return new Promise<T>((resolve, reject) => {
    for (let attempt = 0; attempt < attempts; attempt++) {
      fn().then(value => resolve(value)).catch((reason) => reject(reason))
    }
  })
}

export async function parallelSum(values: Array<Promise<number>>): Promise<number> {
  return Promise.all<number>(values).then((values) => {
    return values.reduce((a, b) => {
      if (!isFinite(a) || !isFinite(b)) {
        throw new Error("Some number is not finite");
      }
      return a + b;
    });
  })
}
