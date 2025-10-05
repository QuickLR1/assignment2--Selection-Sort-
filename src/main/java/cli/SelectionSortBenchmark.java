package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
@Fork(1)
@State(Scope.Thread)
public class SelectionSortBenchmark {

    private int[] data;
    private SelectionSort selectionSort;
    private PerformanceTracker tracker;

    @Param({"100", "1000", "5000"})
    private int size;

    @Setup(Level.Iteration)
    public void setup() {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * 10000);
        }
        tracker = new PerformanceTracker();
        selectionSort = new SelectionSort(tracker);
    }

    @Benchmark
    public void testSelectionSort() {
        int[] copy = Arrays.copyOf(data, data.length);
        selectionSort.sort(copy);
    }
}
