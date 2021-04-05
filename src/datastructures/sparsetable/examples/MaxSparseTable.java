package datastructures.sparsetable.examples;

/*
 * Max sparse table example
 * Construction complexity: O(nlogn), query comlexity: O(1)
 */

// Sparse table for efficient maximum range queries in O(1) with O(nlogn) space
public class MaxSparseTable {

    // Example usage:
    public static void main(String[] args) {
        // index values: 0, 1,  2, 3, 4, 5,  6
        long[] values = {3, 1, -4, 2, 1, 5, -1};
        MaxSparseTable sparseTable = new MaxSparseTable(values);

        System.out.println(sparseTable.queryMax(0, 6));
        System.out.println(sparseTable.queryMaxIndex(0, 6));

        System.out.println(sparseTable.queryMax(0, 2));
        System.out.println(sparseTable.queryMaxIndex(0, 2));

        System.out.println(sparseTable.queryMax(2, 4));
        System.out.println(sparseTable.queryMaxIndex(2, 4));
    }

    // The number of elements in the original input array.
    private int n;

    // The maximum power of 2 needed. This value is floor(log2(n))
    private int P;

    // Fast log base 2 logarithm lookup table, 1 <= i <= n
    private int[] log2;

    // The sparse table values.
    private long[][] dp;

    // Index Table (IT) associated with the values in the sparse table. This table
    // is only useful when we want to query the index of the min (or max) element
    // int the range [l, r] rather than the value itself. The index table doesn't
    // make sense for most other range query types like gcd or sum.
    private int[][] it;

    public MaxSparseTable(long[] values) {
        n = values.length;
        P = (int) (Math.log(n) / Math.log(2));
        dp = new long[P + 1][n];
        it = new int[P + 1][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = values[i];
            it[0][i] = i;
        }

        log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        // Build sparse table combining the values of the previous intervals.
        for (int p = 1; p <= P; p++) {
            for (int i = 0; i + (1 << p) <= n; i++) {
                long leftInterval = dp[p - 1][i];
                long rightInterval = dp[p - 1][i + (1 << (p - 1))];
                dp[p][i] = Math.max(leftInterval, rightInterval);

                // Propagate the index of the best value
                if (leftInterval <= rightInterval) {
                    it[p][i] = it[p - 1][i + (1 << (p - 1))];
                } else {
                    it[p][i] = it[p - 1][i];
                }
            }
        }
    }

    // Do a max query on the interval [l, r] in O(1).
    //
    // We can get O(1) query by finding the smallest power of 2 that fits within
    // the interval length which we'll call k. Then we can query the intervals
    // [l, l+k] and [r-k+1, r] (which likely overlap) and apply the function
    // again. Some functions (like min and max) don't care about overlapping
    // intervals so this trick works, but for a function like sum this would
    // return the wrong result since it is not an idempotent binary function
    // (aka an overlap friendly function).
    private long queryMax(int l, int r) {
        int length = r - l + 1;
        int p = log2[length];
        int k = 1 << p; // 2 to the power of p
        return Math.max(dp[p][l], dp[p][r - k + 1]);
    }

    // Returns the index of the maximum element in the range [l, r].
    public int queryMaxIndex(int l, int r) {
        int length = r - l + 1;
        int p = log2[length];
        int k = 1 << p; // 2 to the power of p
        long leftInterval = dp[p][l];
        long rightInterval = dp[p][r - k + 1];
        if (leftInterval <= rightInterval) {
            return it[p][r - k +1];
        } else {
            return it[p][l];
        }
    }
}
