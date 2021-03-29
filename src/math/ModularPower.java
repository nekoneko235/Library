/*
 * Time Complexity ~O(log(n))
 */

package lib.math;

public class ModularPower {

    public static long modPow(long a, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(modPow(3, 45, 1000000007));
    }
}
