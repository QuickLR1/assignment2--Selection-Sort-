package metrics;

public class TestMetrics {
    public static void main(String[] args) throws InterruptedException {
        PerformanceTracker tracker = new PerformanceTracker();

        tracker.start();
        tracker.incrementComparisons();
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
        Thread.sleep(100);
        tracker.stop();

        System.out.println(tracker);
    }
}
