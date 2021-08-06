package datastructures;

/*
 * Imos Method (Point Query After Range Add)
 * Time Complexity: O(Q + N)
 */

import java.util.Scanner;

public class PointQueryAfterRangeAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();
        long[] arr = new long[n];
        long[] val = new long[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        // Range add: +v into [l, r]
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            long v = in.nextLong();
            val[l] += v;
            val[r+1] -= v;
        }
        for (int i = 0; i < n; i++) {
            arr[i] += val[i]; // add an increased value
            val[i+1] += val[i]; // sum up from left to right
        }

        for (long l : arr) {
            System.out.print(l + " ");
        }
        System.out.println("");

        // Input:
        // n q
        // a1 a2 ... an
        // l1 r1 v1
        // ...
        // lq rq vq

        // 5 4
        // 3 1 4 5 2
        // 1 2 2
        // 2 4 1
        // 0 1 4
        // 2 3 2

        // Output:
        // a1 a2 ... an

        // 7 7 9 8 3
    }
}
