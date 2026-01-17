import { delay, retry, parallelSum } from "../src/exercises/e09_async_promises";

describe("E09 – Async/Promises", () => {
  test("delay espera el tiempo indicado", async () => {
    jest.useFakeTimers();
    const p = delay(500);
    jest.advanceTimersByTime(500);
    await expect(p).resolves.toBeUndefined();
    jest.useRealTimers();
  });

  test("retry reintenta hasta resolver", async () => {
    let n = 0;
    const fn = async () => {
      n++;
      if (n < 3) throw new Error("fail");
      return 42;
    };
    await expect(retry(fn, 3)).resolves.toBe(42);
  });

  test("retry falla si no resuelve", async () => {
    const fn = async () => { throw new Error("always"); };
    await expect(retry(fn, 2)).rejects.toThrow("always");
  });

  test("parallelSum suma en paralelo", async () => {
    await expect(parallelSum([Promise.resolve(1), Promise.resolve(2), Promise.resolve(3)])).resolves.toBe(6);
  });
});
