package io;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    private final String filePath;

    public CSVExporter(String filePath) {
        this.filePath = filePath;
    }

    public void writeHeader() {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write("Algorithm,Array Size,Comparisons,Swaps,Array Accesses,Execution Time (ms)\n");
        } catch (IOException e) {
            System.err.println("Error writing header: " + e.getMessage());
        }
    }

    public void appendRow(String algorithm, int arraySize, long comparisons, long swaps, long arrayAccesses, double timeMs) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%.3f\n",
                    algorithm, arraySize, comparisons, swaps, arrayAccesses, timeMs));
        } catch (IOException e) {
            System.err.println("Error writing row: " + e.getMessage());
        }
    }
}
