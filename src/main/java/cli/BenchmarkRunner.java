package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkRunner {

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10_000);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int maxSize = scanner.nextInt();

        // Список размеров для бенчмарка
        int[] sizes = {10, 50, 100, 500, 1000, maxSize};

        List<Integer> sizesList = new ArrayList<>();
        List<Long> timesList = new ArrayList<>();
        List<Integer> comparisonsList = new ArrayList<>();
        List<Integer> swapsList = new ArrayList<>();
        List<Integer> accessesList = new ArrayList<>();

        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int[] arrCopy = Arrays.copyOf(data, data.length);

            PerformanceTracker tracker = new PerformanceTracker();
            SelectionSort sorter = new SelectionSort(tracker);

            long start = System.nanoTime();
            sorter.sort(arrCopy);
            long end = System.nanoTime();
            long durationMs = (end - start) / 1_000_000;

            System.out.println("\nРазмер массива: " + size);
            System.out.println(tracker);
            System.out.println("Время: " + durationMs + " мс");

            sizesList.add(size);
            timesList.add(durationMs);
            comparisonsList.add(Math.toIntExact(tracker.getComparisons()));
            swapsList.add(Math.toIntExact(tracker.getSwaps()));
            accessesList.add(Math.toIntExact(tracker.getArrayAccesses()));
        }

        // Сохраняем CSV
        saveCSV(sizesList, timesList, comparisonsList, swapsList, accessesList, "benchmark_results.csv");

        // Сохраняем график
        savePlot(sizesList, timesList, "benchmark_plot.png");
    }

    private static void saveCSV(List<Integer> sizes, List<Long> times,
                                List<Integer> comparisons, List<Integer> swaps,
                                List<Integer> accesses, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("ArraySize,TimeMillis,Comparisons,Swaps,ArrayAccesses\n");
            for (int i = 0; i < sizes.size(); i++) {
                writer.append(sizes.get(i) + "," +
                        times.get(i) + "," +
                        comparisons.get(i) + "," +
                        swaps.get(i) + "," +
                        accesses.get(i) + "\n");
            }
            System.out.println("CSV saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void savePlot(List<Integer> sizes, List<Long> times, String fileName) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < sizes.size(); i++) {
            dataset.addValue(times.get(i), "SelectionSort", sizes.get(i));
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Selection Sort Benchmark",
                "Array Size",
                "Time (ms)",
                dataset
        );

        try {
            ChartUtils.saveChartAsPNG(new File(fileName), chart, 800, 600);
            System.out.println("Plot saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
