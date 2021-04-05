package datastructures.sparsetable.examples;

/*
 * GCD sparse table example
 * Construction complexity: O(nlogn), query comlexity: O(1)
 */

// Sparse table for efficient gcd range queries in O(1) with O(nlongn) space
public class GCDSparseTable {

    // Example usage:
    public static void main(String[] args) {
        // index values:  0,  1,  2,  3, 4,  5,  6,  7,  8,  9
        long[] values = {18, 44, 86, 66, 6, 51, 55, 60, 64, 30};
        GCDSparseTable sparseTable = new GCDSparseTable(values);

        System.out.println(sparseTable.queryGCD(0, 9)); // prints 1
        System.out.println(sparseTable.queryGCD(0, 4)); // prints 2
        System.out.println(sparseTable.queryGCD(3, 7)); // prints 1
        System.out.println(sparseTable.queryGCD(3, 4)); // prints 6
        System.out.println(sparseTable.queryGCD(6, 7)); // prints 5
    }

    // The number of elements in the original input array.
    private int n;

    // The maximum power of 2 needed. This value is floor(log2(n))
    private int P;

    // Fast log base 2 logarithm lookup table, 1 <= i <= n
    private int[] log2;

    // The sparse table values
    private long[][] dp;

    public GCDSparseTable(long[] values) {
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
                dp[p][i] = gcd(leftInterval, rightInterval);
            }
        }
    }

    // Do a gcd query on the interval [l, r] in O(1).
    //
    // We can get O(1) query by finding the smallest power of 2 that fits within
    // the interval length which we'll call k. Then we can query the intervals
    // [l, l+k] and [r-k+1, r] (which likely overlap) and apply the function
    // again. Some functions (like min and max) don't care about overlapping
    // intervals so this trick works, but for a function like sum this would
    // return the wrong result since it is not an idempotent binary function
    // (aka an overlap friendly function).
    private long queryGCD(int l, int r) {
        int length = r - l + 1;
        int p = log2[length];
        int k = 1 << p; // 2 to the power of p
        return gcd(dp[p][l], dp[p][r - k + 1]);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? (a < 0 ? -a : a) : gcd(b, a % b);
    }
}
