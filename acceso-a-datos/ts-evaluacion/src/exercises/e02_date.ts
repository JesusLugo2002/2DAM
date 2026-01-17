/**
 * E02 – Date: parseo YYYY-MM-DD, validación y diferencias en días.
 */

export function isValidISODate(iso: string): boolean {
  const dateISORegex = new RegExp(/^\d{4}(?:\-\d{2}){2}$/);
  if (iso.match(dateISORegex) == null) {
    return false;
  }
  return iso === toIsoDateOnly(new Date(iso));
}

export function nightsBetween(entrada: string, salida: string): number {
  if (!isValidISODate(entrada) || !isValidISODate(salida)) {
    throw new Error("Invalid dates");
  }
  const startTime = new Date(entrada).getTime();
  const endTime = new Date(salida).getTime();
  if (endTime <= startTime) {
    throw new Error("The end time is lower or equals to the starting time")
  }
  const timeInMs = endTime - startTime;
  const msInDay = 1000 * 60 * 60 * 24;
  return timeInMs / msInDay;
}

export function toIsoDateOnly(date: Date): string {
  let result;
  try {
    result = date.toISOString();
  } catch (e: unknown) {
    throw new Error("Invalid date");
  }
  return result.substring(0, 10);
}
