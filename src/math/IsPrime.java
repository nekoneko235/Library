// Tests whether a number is a prime number or not
// Time Complexity: O(sqrt(n))

package math;

public class IsPrime {

    public static boolean isPrime(long N) {
        if (N == 1) return false;
        for (long i = 2; i * i <= N; ++i) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(5));
        System.out.println(isPrime(31));
        System.out.println(isPrime(1433));
        System.out.println(isPrime(8763857775536878331L));
    }
}
