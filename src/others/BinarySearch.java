package others;

import java.util.*;

public class BinarySearch {

    // Binary search template
    static int binarySearch(boolean isLower, int key) {
        int ng; int ok;
        if (isLower) {
            // Lower bound
            ng = -1;
            ok = arr.size();
        } else {
            // Upper bound
            ok = -1;
            ng = arr.size();
        }

        // We don't know which is bigger
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;

            if (isOk(mid, isLower, key)) ok = mid;
            else ng = mid;
        }

        if (isLower) return ok;
        else return ng;
    }

    // Helper method for binarySearch
    // Check if the index meets the condition
    static boolean isOk(int index, boolean isLower, int key) {
        if (isLower) {
            // Lower bound
            if (arr.get(index) >= key) return true;
            else return false;
        } else {
            // Upper bound
            if (arr.get(index) > key) return false;
            else return true;
        }
    }

    // Comparator for searching lower bound
    // Make sure to negate the return value
    static class LowerBoundComparator<T extends Comparable<? super T>>
            implements Comparator<T>
    {
        public int compare(T x, T y)
        {
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
    }

    // Comparator for searching upper bound
    // Make sure to negate the return value
    static class UpperBoundComparator<T extends Comparable<? super T>>
            implements Comparator<T>
    {
        public int compare(T x, T y)
        {
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }

    static List<Integer> arr;

    public static void main(String[] args) {
        arr = Arrays.asList(1, 2, 2, 4, 6, 6, 6, 7, 9, 10, 10);
        System.out.println(arr.toString());

        int lowerBound = ~Collections.binarySearch(arr, 6,
                new LowerBoundComparator<>());
        int upperBound = ~Collections.binarySearch(arr, 6,
                new UpperBoundComparator<>());

        System.out.println("Lower bound using Collections.binarySearch : " +
                lowerBound); // output: 4
        System.out.println("Upper bound using Collections.binarySearch : " +
                upperBound); // output: 7
        System.out.println("Number of the elements : " +
                (upperBound - lowerBound)); // output: 3

        System.out.println("lower bound : " + binarySearch(true, 6)); // 4
        System.out.println("upper bound : " + binarySearch(false, 6)); // 7
    }
}
