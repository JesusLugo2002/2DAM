/** @type {import('jest').Config} */
module.exports = {
  preset: "ts-jest",
  testEnvironment: "node",
  testMatch: ["<rootDir>/tests/**/*.test.ts"],
  reporters: [
    "default",
    ["<rootDir>/scripts/gradeReporter.js", {}]
  ]
};
