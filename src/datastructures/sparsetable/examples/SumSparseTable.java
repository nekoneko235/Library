package datastructures.sparsetable.examples;

/*
 * Sum sparse table example
 * Construction complexity: O(nlogn), query comlexity: O(logn)
 */

// Sparse table for efficient summation range queries in O(logn) with O(nlogn) space
public class SumSparseTable {

    // Example usage:
    public static void main(String[] args) {
        // index values: 0, 1,  2, 3, 4,  5, 6
        long[] values = {1, 2, -3, 2, 4, -1, 5};
        SumSparseTable sparseTable = new SumSparseTable(values);

        System.out.println(sparseTable.querySum(0, 6)); // prints 10
        System.out.println(sparseTable.querySum(0, 3)); // prints 2
        System.out.println(sparseTable.querySum(4, 6)); // prints 8
        System.out.println(sparseTable.querySum(0, 0)); // prints 1
    }

    // The number of elements in the original input array.
    private int n;

    // The maximum power of 2 needed. This value is floor(log2(n))
    private int P;

    // Fast log base 2 logarithm lookup table, 1 <= i <= n
    private int[] log2;
    
    // The sparse table values.
    private long[][] dp;
    
    public SumSparseTable(long[] values) {
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
                dp[p][i] = leftInterval + rightInterval;
            }
        }
    }

    // Do a sum query on the interval [l, r] in O(logn).
    // cascading sum query
    private long querySum(int l, int r) {
        long sumVal = 0;
        for (int p = log2[r - l + 1]; l <= r; p = log2[r - l + 1]) {
            sumVal += dp[p][l];
            l += (1 << p);
        }
        return sumVal;
    }
}
