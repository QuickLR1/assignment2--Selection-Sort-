package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {
    private final PerformanceTracker tracker;

    public SelectionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        tracker.start();

        boolean sorted;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            sorted = true;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    sorted = false;
                }
            }


            if (sorted) break;

            if (minIndex != i) {
                swap(arr, i, minIndex);
                tracker.incrementSwaps();
            }
        }

        tracker.stop();
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
