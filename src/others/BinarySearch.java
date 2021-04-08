package others;

import java.util.*;

public class BinarySearch {

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

    // Binary search template
    static int binarySearch(int key) {
        int ng = -1;
        int ok = arr.size();

        // We don't know which is bigger
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;

            if (isOk(mid, key)) ok = mid;
            else ng = mid;
        }
        return ok;
    }

    // Helper method for binarySearch
    // Check if the index meets the condition
    static boolean isOk(int index, int key) {
        //Lower bound
        if (arr.get(index) >= key) return true;
        else return false;
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

        System.out.println("lower bound : " + binarySearch(6));
    }
}
