package others;

/*
 * Time Complexity: O(n)
 * Problem: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/3/DSL_3_C
 */

import java.util.Scanner;

public class TwoPointers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input
        int n = in.nextInt();
        int q = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        // Query
        for (int i = 0; i < q; i++) {
            // Each query x
            long x = in.nextLong();

            // Sum
            long res = 0;

            // Divided by at the left end of the section
            int right = 0;
            long sum = 0;
            for (int left = 0; left < n; left++) {
                while (right < n && sum + a[right] <= x) {
                    sum += a[right];
                    ++right;
                }

                // right is the max value which satisfy the condition
                res += right - left;

                // Preprocessing before increment left
                if (right == left) ++right;
                else sum -= a[left];
            }
            System.out.println(res);
        }
    }
}
