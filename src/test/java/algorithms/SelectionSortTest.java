package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};

        sorter.sort(arr);

        assertArrayEquals(expected, arr);
        System.out.println(tracker);
    }

    @Test
    public void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        int[] arr = {5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
