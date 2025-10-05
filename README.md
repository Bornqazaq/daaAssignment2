# Assignment 2 — Insertion Sort (Student A)

This project is part of Assignment 2 for the Design and Analysis of Algorithms course.  
It contains an optimized implementation of **Insertion Sort**, designed for nearly-sorted data.

## ✅ Features

- Java implementation of Insertion Sort
- Optimization: skips shifting when data is already in order
- Performance metrics:
    - Comparisons
    - Swaps
    - Array accesses
- CLI benchmark runner
- Unit tests with JUnit 5
- CSV export for analysis

## 🗂️ Project Structure

```
assignment2-insertion-sort/
├── src/
│   ├── main/java/
│   │   ├── algorithms/InsertionSort.java
│   │   ├── metrics/PerformanceTracker.java
│   │   └── cli/BenchmarkRunner.java
│   └── test/java/algorithms/InsertionSortTest.java
├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
│       └── benchmark_results.csv
├── README.md
└── pom.xml
```

## 🚀 How to Run

### 1. Compile and test
```bash
mvn clean compile
mvn test
```

### 2. Run benchmarks
```bash
java -cp target/classes cli.BenchmarkRunner
```

Output is saved to:
```
docs/performance-plots/benchmark_results.csv
```

## 📊 Benchmark Sizes

Tested on input sizes:
- 100
- 1,000
- 10,000
- 100,000

Each run collects:
- Execution time (ms)
- Comparisons
- Swaps
- Array accesses

## 👥 Team

- **Student A (Insertion Sort):** [Nurbek Yerbulekov]
- **Student B (Selection Sort):** [Nurzhan Zhumabekov]