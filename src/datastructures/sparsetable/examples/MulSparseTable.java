package datastructures.sparsetable.examples;

/*
 * Multiplication sparse table example
 * Construction complexity: O(nlogn), query comlexity: O(logn)
 */

// Sparse table for efficient multiplication range queries in O(logn) with O(nlogn) space
public class MulSparseTable {

    // Example usage:
    public static void main(String[] args) {
        // index values: 0, 1,  2, 3, 4,  5, 6
        long[] values = {1, 2, -3, 2, 4, -1, 5};
        MulSparseTable sparseTable = new MulSparseTable(values);

        System.out.println(sparseTable.queryMul(0, 6));
        System.out.println(sparseTable.queryMul(0, 3));
        System.out.println(sparseTable.queryMul(4, 6));
        System.out.println(sparseTable.queryMul(0, 0));
    }

    // The number of elements in the original input array.
    private int n;

    // The maximum power of 2 needed. This value is floor(log2(n))
    private int P;

    // Fast log base 2 logarithm lookup table, 1 <= i <= n
    private int[] log2;

    // The sparse table values.
    private long[][] dp;

    public MulSparseTable(long[] values) {
        n = values.length;
        P = (int) (Math.log(n) / Math.log(2));
        dp = new long[P + 1][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = values[i];
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
                dp[p][i] = leftInterval * rightInterval;
            }
        }
    }

    // Do a multiplication query on the interval [l, r] int O(logn).
    // cascading multiplication query
    private long queryMul(int l, int r) {
        int mulVal = 1;
        for (int p = log2[r - l + 1]; l <= r; p = log2[r - l + 1]) {
            mulVal *= dp[p][l];
            l += (1 << p);
        }
        return mulVal;
    }
}
