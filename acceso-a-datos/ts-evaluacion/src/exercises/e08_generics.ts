/**
 * E08 – Genéricos
 */

export function first<T>(items: T[]): T {
  if (items.length == 0) {
    throw new Error("Items are empty");
  }
  return items[0];
}

export function unique<T>(items: T[]): T[] {
  return [...new Set(items)];
}

export function groupBy<T, K extends string | number>(
  items: T[],
  keyFn: (item: T) => K
): Record<K, T[]> {
  const result = new Map<K, T[]>();
  items.forEach(item => {
    const key = keyFn(item);
    const value = result.get(key);
    if (value == undefined) {
      result.set(key, [item])
    } else {
      value.push(item);
      result.set(key, value);
    }
  });
  return Object.fromEntries(result) as Record<K, T[]>;
}
