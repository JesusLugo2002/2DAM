const fs = require("fs");
const path = require("path");


class GradeReporter {
  onRunComplete(_contexts, results) {
    const weights = {
      "tests/e01-basicos.test.ts": 1.0,
      "tests/e02-date.test.ts": 1.0,
      "tests/e03-arrays.test.ts": 1.0,
      "tests/e04-tuples-enum.test.ts": 1.0,
      "tests/e05-union-guards.test.ts": 1.2,
      "tests/e06-intersection-record.test.ts": 1.2,
      "tests/e07-map-set.test.ts": 1.2,
      "tests/e08-generics.test.ts": 1.4,
      "tests/e09-async-promises.test.ts": 1.5,
      "tests/e10-errors-validation.test.ts": 1.5
    };

    const byFile = new Map();

    for (const tr of results.testResults) {
      const rel = path.relative(process.cwd(), tr.testFilePath).replace(/\\/g, "/");
      if (!rel.startsWith("tests/")) continue;

      const total = tr.numPassingTests + tr.numFailingTests + tr.numPendingTests + tr.numTodoTests;
      const passed = tr.numPassingTests;
      const weight = weights[rel] ?? 1.0;
      const ratio = total === 0 ? 0 : passed / total;

      byFile.set(rel, { total, passed, weight, ratio, points: weight * ratio });
    }

    const sumW = [...byFile.values()].reduce((a, x) => a + x.weight, 0) || 1;
    const sumPoints = [...byFile.values()].reduce((a, x) => a + x.points, 0);
    const final10 = Math.round(((sumPoints / sumW) * 10) * 100) / 100;

    const nota = {
      final: final10,
      escala: "0..10",
      ejercicios: Object.fromEntries([...byFile.entries()].map(([k, v]) => [k, {
        peso: v.weight,
        tests_aprobados: v.passed,
        tests_totales: v.total,
        porcentaje: Math.round(v.ratio * 10000) / 100,
        puntos: Math.round(v.points * 100) / 100
      }])),
      resumen: {
        total_tests: results.numTotalTests,
        aprobados: results.numPassedTests,
        fallados: results.numFailedTests
      }
    };

    const outDir = path.join(process.cwd(), "nota");
    if (!fs.existsSync(outDir)) fs.mkdirSync(outDir, { recursive: true });

    fs.writeFileSync(path.join(outDir, "nota.json"), JSON.stringify(nota, null, 2), "utf-8");

    const lines = [];
    lines.push(`NOTA FINAL: ${nota.final}/10`);
    lines.push(`Tests: ${nota.resumen.aprobados} aprobados, ${nota.resumen.fallados} fallados, ${nota.resumen.total_tests} total`);
    lines.push("");
    lines.push("Detalle por ejercicio (puntos ponderados):");
    for (const [file, v] of Object.entries(nota.ejercicios)) {
      lines.push(`- ${file}: ${v.puntos}/${v.peso} | ${v.tests_aprobados}/${v.tests_totales} (${v.porcentaje}%)`);
    }
    fs.writeFileSync(path.join(outDir, "nota.txt"), lines.join("\n"), "utf-8");
  }
}

module.exports = GradeReporter;
