package math;

import java.util.ArrayList;
import java.util.Collections;

public class EnumDivisors {

    public static ArrayList<Long> enumDivisors(long N) {
        ArrayList<Long> res = new ArrayList<>();
        for (long i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                res.add(i);

                // add N/i provided that N / i != i
                if (N/i != i) res.add(N/i);
            }
        }

        // sort by ascending order
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Long> list = enumDivisors(24L);
        System.out.println(list);
    }
}
