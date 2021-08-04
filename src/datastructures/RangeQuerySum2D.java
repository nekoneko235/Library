package datastructures;

/*
 * Range Sum Query 2D implementation.
 * Time Complexity: O(H * W) Grid size: H * W.
 */

import java.util.Scanner;

public class RangeQuerySum2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: h x w size grid
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        // 2D Range Sum Query
        int[][] sum = new int[h+1][w+1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
            }
        }

        // Query: Sum of [h1, h2) x [w1, w2) Rectangle Area
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int h1 = in.nextInt();
            int h2 = in.nextInt();
            int w1 = in.nextInt();
            int w2 = in.nextInt();
            System.out.println(sum[h2][w2] - sum[h1][w2] - sum[h2][w1] + sum[h1][w1]);
        }

        // 1st Input: 3 + 4 + 6 + 8 + 1 + 4 = 26
        // 2nd Input: 8 + 7 + 1 + 3 = 19
        // 3rd Input: Whole Sum 84
    }
}
