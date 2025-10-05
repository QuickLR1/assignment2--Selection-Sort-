package io;

import metrics.PerformanceTracker;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    public static void exportPerformance(String algorithmName, PerformanceTracker tracker, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {

            if (writer.getEncoding() != null) {
                writer.write("Algorithm,Comparisons,Swaps,ArrayAccesses,ExecutionTime(ms)\n");
            }

            double execTimeMs = tracker.getExecutionTime() / 1_000_000.0;

            writer.write(String.format(
                    "%s,%d,%d,%d,%.3f\n",
                    algorithmName,
                    tracker.getComparisons(),
                    tracker.getSwaps(),
                    tracker.getArrayAccesses(),
                    execTimeMs
            ));
        } catch (IOException e) {
            System.err.println("Ошибка при записи CSV: " + e.getMessage());
        }
    }
}
