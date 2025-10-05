package io;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import io.CSVExporter;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CSVExporterTest {

    @Test
    public void testExportPerformance() throws IOException {
        PerformanceTracker tracker = new PerformanceTracker();
        tracker.start();
        tracker.incrementComparisons();
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
        tracker.stop();

        String filePath = "test_metrics.csv";
        CSVExporter.exportPerformance("SelectionSort", tracker, filePath);

        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        // Удаляем файл после теста
        assertTrue(file.delete());
    }
}
