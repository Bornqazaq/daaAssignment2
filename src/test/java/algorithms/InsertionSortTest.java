package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        InsertionSort sorter = new InsertionSort(new PerformanceTracker());
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        InsertionSort sorter = new InsertionSort(new PerformanceTracker());
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort sorter = new InsertionSort(new PerformanceTracker());
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseOrder() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort sorter = new InsertionSort(new PerformanceTracker());
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testWithDuplicates() {
        int[] input = {4, 2, 5, 2, 3, 1};
        int[] expected = {1, 2, 2, 3, 4, 5};
        InsertionSort sorter = new InsertionSort(new PerformanceTracker());
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }
}