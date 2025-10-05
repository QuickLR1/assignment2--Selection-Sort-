package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        int size = scanner.nextInt();

        int[] data = generateRandomArray(size);
        int[] arrCopy = Arrays.copyOf(data, data.length);

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        sorter.sort(arrCopy);

        System.out.println("\nРезультаты:");
        System.out.println(tracker);
    }
}
