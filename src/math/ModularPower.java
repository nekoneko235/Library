/*
 * Time Complexity ~O(log(n))
 */

package math;

import java.math.BigInteger;

public class ModularPower {

    static long mod = 1000000007;

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

    static long modpow(long N, long K) {
        return BigInteger.valueOf(N).
                modPow(BigInteger.valueOf(K), BigInteger.valueOf(mod))
                .longValue();
    }

    public static void main(String[] args) {
        System.out.println(modPow(3, 45, 1000000007));
    }
}
