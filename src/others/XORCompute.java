package others;

// Calculate xor of consecutive integers from M to N
// M > 0, N > M

public class XORCompute {
    public static int calc(int M, int N) {
        return xORTrick(N) ^ xORTrick(M - 1);
    }

    private static int xORTrick(int n) {
        if (n % 4 == 0) {
            return n;
        }

        if (n % 4 == 1) {
            return 1;
        }

        if (n % 4 == 2) {
            return n + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calc(2, 84));
    }
}
