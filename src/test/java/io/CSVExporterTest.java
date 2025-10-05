package io;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVExporterTest {

    @Test
    public void testCSVExport() {
        String path = "test_results.csv";
        CSVExporter exporter = new CSVExporter(path);
        exporter.writeHeader();
        exporter.appendRow("SelectionSort", 5, 10, 3, 15, 0.512);

        File file = new File(path);
        assertTrue(file.exists());
        file.delete();
    }
}
