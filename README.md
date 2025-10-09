# Assignment 2 — Selection Sort with Performance Tracking

## 📘 Overview
This project implements **Selection Sort** in Java with a focus on performance analysis and optimization.  
The implementation includes:
- `PerformanceTracker` — measures comparisons, swaps, and execution time.
- `BenchmarkRunner` — runs sorting tests and exports performance data to CSV.
- Optimized Selection Sort — includes early-exit condition for nearly sorted arrays.

---

## 🚀 How to Run

### 🧩 1. Build the Project
```bash
mvn clean compile
🧪 2. Run Tests
bash
mvn test
⚙️ 3. Run Benchmark CLI
bash
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
The program will:

Generate arrays of various sizes,

Sort them using Selection Sort,

Output performance metrics and save results to a CSV file.

📊 Performance Metrics
Metric	Description
Comparisons	Number of element comparisons
Swaps	Number of swaps performed
Array Accesses	Number of times array elements were accessed
Execution Time	Duration in milliseconds

📈 Complexity Analysis
Case	Time Complexity	Space Complexity	Description
Best	Ω(n²)	O(1)	Even if sorted, full comparison still happens (unless optimized).
Average	Θ(n²)	O(1)	Typical case for random input.
Worst	O(n²)	O(1)	Completely reversed or random input.

The algorithm is in-place and does not require additional memory beyond a few variables.

🧩 Project Structure
bash
assignment2--Selection-Sort-/
│
├── src/
│   ├── main/java/
│   │   ├── algorithms/SelectionSort.java
│   │   ├── metrics/PerformanceTracker.java
│   │   └── cli/BenchmarkRunner.java
│   └── test/java/
│       └── algorithms/SelectionSortTest.java
│
├── docs/
│   └── analysis-report.pdf
│
├── pom.xml
└── README.md
🏁 Authors
QuickLR1 — Implementation, testing, optimization, and documentation.
