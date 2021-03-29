/*
 * Copyright (c) 2017 William Fiset
 * Released under the MIT license
 * https://github.com/williamfiset/Algorithms/blob/master/LICENSE
 *
 * Fundamental bit manipulation operations you must know Time Complexity: O(1)
 */
package others;

public class BitManipulations {

    // Sets the i'th bit to 1
    public static int setBit(int set, int i) {
        return set | (1 << i);
    }

    // Checks if the i'th is set
    public static boolean isSet(int set, int i) {
        return (set & (1 << i)) != 0;
    }

    // Sets the i'th bit to zero
    public static int clearBit(int set, int i) {
        return set & ~(1 << i);
    }

    // Toggles the i'th bit from 0 -> 1 or 1 -> 0
    public static int toggleBit(int set, int i) {
        return set ^ (1 << i);
    }

    // Returns a number with the first n bits set to 1
    public static int setAll(int n) {
        return (1 << n) - 1;
    }

    // Verifies if a number n is a power of two
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Count number of 1's
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
