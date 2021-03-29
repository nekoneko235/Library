/*
 * Copyright (c) 2017 William Fiset
 * Released under the MIT license
 * https://github.com/williamfiset/Algorithms/blob/master/LICENSE
 *
 * Use the sieve of eratosthenes to find all the prime numbers up to a certain limit.
 */
package lib.math;

public class SieveOfEratosthenes {

    // Gets all primes up to our limit (inclusive) (returned as a list of primes)
    public static int[] sieve(int limit) {

        if (limit <= 1) return new int[]{};
        if (limit == 2) return new int[]{2};

        // Find an upper bound on the number of prime numbers up to our limit.
        final int numPrimes = (int) (1.25506 * limit / Math.log((double) limit));
        int[] primes = new int[numPrimes];
        int index = 0;

        boolean[] isComposite = new boolean[limit + 1];
        final int sqrtLimit = (int) Math.sqrt(limit);
        for (int i = 2; i <= sqrtLimit; i++) {
            if (!isComposite[i]) {
                primes[index++] = i;
                for (int j = i * i; j <= limit; j += i) isComposite[j] = true;
            }
        }
        for (int i = sqrtLimit + 1; i <= limit; i++) if (!isComposite[i]) primes[index++] = i;
        return java.util.Arrays.copyOf(primes, index);
    }

    public static void main(String[] args) {

        // Generate all the primes up to 29 inclusive
        int[] primes = sieve(29);

        // Prints [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
        System.out.println(java.util.Arrays.toString(primes));

    }
}
