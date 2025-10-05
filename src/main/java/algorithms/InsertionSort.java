package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker;

    public InsertionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            tracker.incrementArrayAccess(); // read key
            tracker.incrementComparisons(); // compare key with array[j]

            // 🧠 Optimization: stop early if already in order
            if (array[j] <= key) {
                tracker.incrementArrayAccess(); // array[j]
                continue;
            }

            while (j >= 0 && array[j] > key) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccess(); // array[j]
                tracker.incrementArrayAccess(); // array[j+1]
                tracker.incrementSwaps();

                array[j + 1] = array[j];
                j--;
            }
            tracker.incrementArrayAccess(); // key assignment
            array[j + 1] = key;
        }
    }
}