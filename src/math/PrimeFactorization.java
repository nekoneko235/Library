package lib.math;

import java.util.ArrayList;

public class PrimeFactorization {

    static class Pair<U extends Comparable<U>, V extends Comparable<V>>
            implements Comparable<Pair<U, V>>
    {
        private U first;   	// first field of a Pair
        private V second;  	// second field of a Pair

        // Constructs a new Pair with specified values
        public Pair(U first, V second)
        {
            super();
            this.first = first;
            this.second = second;
        }

        // Getter and Setter
        public U getFirst() {
            return first;
        }

        public void setFirst(U first) {
            this.first = first;
        }

        public V getSecond() {
            return second;
        }

        public void setSecond(V second) {
            this.second = second;
        }

        @Override
        // sorting list of pair by first elem and then sort again by second elem
        public int compareTo(Pair<U, V> o) {
            int cmp = this.getFirst().compareTo(o.getFirst());
            if (cmp == 0) {
                cmp = this.getSecond().compareTo(o.getSecond());
            }
            return cmp;
        }

        @Override
        // Checks specified object is "equal to" current object or not
        public boolean equals(Object o)
        {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            // call equals() method of the underlying objects
            if (!first.equals(pair.first))
                return false;
            return second.equals(pair.second);
        }

        @Override
        // Computes hash code for an object to support hash tables
        public int hashCode()
        {
            // use hash codes of the underlying objects
            return 31 * first.hashCode() + second.hashCode();
        }

        @Override
        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }

        // Factory method for creating a Typed Pair immutable instance
        public static <U extends Comparable<U>, V extends Comparable<V>> lib.others.Pair<U, V> of(U a, V b)
        {
            // calls private constructor
            return new lib.others.Pair<>(a, b);
        }
    }

    public static ArrayList<Pair> primeFactorization(long N) {
        ArrayList<Pair> res = new ArrayList<>();
        for (long a = 2; a * a <= N; ++a) {
            if (N % a != 0) continue;
            long ex = 0; // exponents

            while (N % a == 0) {
                ++ex;
                N /= a;
            }

            res.add(new Pair(a, ex));
        }

        if (N != 1) res.add(new Pair(N, 1));
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Pair> list = primeFactorization(28);
        System.out.println(list);
    }
}
