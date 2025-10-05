package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] inputSizes = {100, 1000, 10_000, 100_000};

        try (FileWriter writer = new FileWriter("docs/performance-plots/benchmark_results.csv")) {
            writer.write("size,time_ms,comparisons,swaps,array_accesses\n");

            for (int size : inputSizes) {
                int[] data = generateRandomArray(size);

                PerformanceTracker tracker = new PerformanceTracker();
                InsertionSort sorter = new InsertionSort(tracker);

                long startTime = System.nanoTime();
                sorter.sort(data);
                long endTime = System.nanoTime();

                double durationMs = (endTime - startTime) / 1_000_000.0;

                writer.write(size + "," + durationMs + "," +
                        tracker.getComparisons() + "," +
                        tracker.getSwaps() + "," +
                        tracker.getArrayAccesses() + "\n");

                System.out.println("Size: " + size);
                System.out.println("Time (ms): " + durationMs);
                System.out.println("Comparisons: " + tracker.getComparisons());
                System.out.println("Swaps: " + tracker.getSwaps());
                System.out.println("Array Accesses: " + tracker.getArrayAccesses());

                if (!isSorted(data)) {
                    System.out.println("Sort failed for input size: " + size);
                }
                System.out.println();
            }

            System.out.println("Results saved to: docs/performance-plots/benchmark_results.csv");

        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static int[] generateRandomArray(int length) {
        Random rand = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = rand.nextInt(length * 10);
        }
        return result;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}