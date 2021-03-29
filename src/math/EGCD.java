/*
 * Copyright (c) 2017 William Fiset
 * Released under the MIT license
 * https://github.com/williamfiset/Algorithms/blob/master/LICENSE
 *
 * Time Complexity ~O(log(a + b))
 */

package math;

import java.util.Arrays;

public class EGCD {

    // This function performs the extended euclidean algorithm on two numbers a and b.
    // The function returns the gcd(a,b) as well as the numbers x and y such
    // that ax + by = gcd(a,b). This calculation is important in number theory
    // and can be used for several things such as finding modular inverses and
    // solutions to linear Diophantine equations.
    // return value := { d := gcd(a, b), x, y }
    public static long[] egcd(long a, long b) {
        if (b == 0) return new long[] {a, 1, 0};
        else {
            long[] ret = egcd(b, a % b);
            long tmp = ret[1] - ret[2] * (a / b);
            ret[1] = ret[2];
            ret[2] = tmp;
            return ret;
        }
    }

    public static void main(String[] args) {
        long[] arr = egcd(12, 37);
        System.out.println(Arrays.toString(arr));
    }
}

