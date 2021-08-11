package others;

import java.io.PrintWriter;

public class MemoForCP {
    public static void main(String[] args) {
        int x = 1234; int y = 4321;
        Integer.bitCount(x); //x2の補数バイナリ表現で1の数
        Integer.numberOfLeadingZeros(x); //xの2の補数バイナリ表現で先頭に続く0の数
        Integer.numberOfTrailingZeros(x); //xの2の補数バイナリ表現で末尾に連続する0の数
        Integer.compare(x, y); //x < yならば負の数、x == yならば0、x > yならば正の数を返す
        Integer.toString(2,2); //数値を指定した基数で文字列に変換する
        Integer.parseInt("10", 2); //指定した基数で表される文字列数値を１０進数数値に変換する
        Integer.toBinaryString(2); //数値を2進数の文字列にする
        Integer.toHexString(17); //数値を16進数の文字列にする
        Integer.highestOneBit(7); // 4: 1の最上位ビットの x の 2^x を返す
    }

    /*
    +演算子を使うことで文字列の結合をすることができます。
    しかし、たくさんの文字列を繰り返し処理などで結合したい場合はStringBuilderを用いた方が高速です。
    文字列結合をした後出力するだけならば、直接出力するのも手でしょう。
     */
    // 遅い
    static String repeatString1(String s,int n) {
        String ret = "";
        for (int i = 0; i < n; i++) {
            ret += s;
        }
        return ret;
    }
    //速い
    static String repeatString2(String s,int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    /*
    出力:
    標準出力に文字列を書き出すには普通System.out.printlnを用いますが、デフォルトではオートフラッシュが有効なため低速です。
    解決策の一つとして、PrintWriterを用いて自動フラッシュをしないようにする方法があります。
    この場合、プログラムの終了まえにフラッシュを忘れないよう注意してください。
     */
    static void printOut() {
        PrintWriter out = new PrintWriter(System.out);
        int n = 100;
        for (int i = 0; i < n; i++) {
            out.println("hoge");
        }
        out.flush();
    }

    /*
    ラッパークラスの比較:
    ラッパークラス同士を比較するときも、必ずequalsを使うようにしましょう。
    ラッパー型の変数を宣言していなくても、標準ライブラリの返り値などに現れるので注意しましょう。
    (ArrayList<Integer>を使う場合など)
     */
    static void compareRapper() {
        Integer wrapped1 = Integer.valueOf(123456);
        Integer wrapped2 = Integer.valueOf(123456);
        int primitive1 = 123456;
        int primitive2 = 123456;

        //大丈夫
        System.out.println(primitive1 == primitive2);
        System.out.println(primitive1 == wrapped1);
        System.out.println(wrapped1 == primitive1);

        //参照の比較になるのでダメ
        System.out.println(wrapped1 == wrapped2);
    }

    /*
    桁数の取得:
    数字を文字列に変換すれば、その長さが桁数となる。
     */
    public static int digits(long n) {
        return String.valueOf(n).length();
    }

    /*
    配列の中身が等価か比較
    Arrays.deepEquals(A, B)
     */

    /*
    ソート:
    プリミティブ型(int,long,doubleなど)の配列のソートをArrays.sort()ですると、最悪計算量がΘ(n2)Θ(n2)になります。
    これはプリミティブ型の配列をソートする際のアルゴリズムがクイックソート(の改良版)であるためで、ほとんどの場合は問題になりません。
    ただし、作問側が意地悪な場合や、参加者がテストケースを作れるTopcoderやCodeforcesでは狙われる可能性があります。
    対策としては、ラッパ型(Integer,Long,Doubleなど)の配列でソートする方法があります。
     */

    /*
    配列の最大値・最小値:
    for文を回さなくても、Arraysで取得可能

    Arrays.stream([配列名]).min().getAsInt()
    Arrays.stream([配列名]).max().getAsInt()
     */

    /*
    文字列への変換:
    char型配列を引数とするとその配列をつなぎ合わせた文字列となる。

    char[] c = {'a', 'b', 'c'};
    String.valueOf(c) //"abc"が返される
     */

    /*
    一般に、正整数 x, y に対し、x/y を切り上げた値は (x + y − 1)/y (ここで / は整数除算を表す) として実装す
    ることができます。
     */

    /*
    2 to the power of x >= P となるような最小の x を求めたい場合
    int x = 0;
    while (P > 1) {
        P = (P + 2 - 1) / 2;
        ++x;
    }
     */

    /*
    縦H、横Wマスの盤面がある。ビショップが(r1, c1)にあり(r2, c2)に動ける条件は
    1. r1 + c1 = r2 + c2
    2. r1 - c1 = r2 - c2
    のうちちょうど一方が成立することと同値
     */

    /*
    マンハッタン距離:
    座標平面上の２点、A(a1, a2), B(b1, b2)の間の距離を
    d(A,B) = |a1 - b1| + |a2 - b2|
    で測ったものをマンハッタン距離と言う。

    1. d(A,B) >= 0 or d(A,B) = 0 <=> A = B
    2. d(A,B) = d(B,A)
    3. d(A,B) + d(B,C) >= d(A,C)
     */

    /*
    カッコ列が正しいかどうかの判定は、以下の２条件を両方満たすことが必要十分条件になっている
    1. '('と')'の数が同じである
    2. 全てのi(1<=i<=N)について、左からi文字目までの時点で'('の数が')'の数以上である
     */

    /*
    低の変換公式
    a,b,c >0, a,c != 1 のとき
    log(a)b = log(c)b / log(c)a
     */

    /*
    等差数列の一般項
    a(n) = a + (n-1) * d
    初項 a, 公差 d
     */

    /*
    等差数列の和の公式
    初項 a, 末項 l, 項数 n の等差数列の和 Snは
    Sn = n * (a + l) / 2
    初項 a, 公差 d の等差数列の初項から 第n項 までの和 Snは
    Sn = {2a + (n - 1) * d} * n / 2
     */

    /*
    1 + 2 + 3 + ... + n = 1 / 2 * n * (n + 1)
    1 + 3 + 5 + ... + (2n - 1) = n * n  // 連続したn個の奇数
    1^2 + 2^2 + 3^2 + ... + n^2 = 1 / 6 * n * (n + 1) * (2n + 1)
    1^3 + 2^3 + 3^3 + ... + n^3 = 1 / 4 * n^2 * (n + 1)^2
    2^0 + 2^1 + 2^2 + ... + 2^N-1 = 2^N - 1
    1 + p + p^2 + p^3 + ... = 1 / (1 - p) [0 < p < 1]
    3^2 + 4^2 = 5^2
    10^2 + 11^2 + 12^2 = 13^2 + 14^2
    21^2 + 22^2 + 23^2 + 24^2 = 25^2 + 26^2 + 27^2
     */

    /*
    等比数列の一般項
    a(n) = a * r^(n - 1)
    初項 a, 公比 r
     */

    /*
    等比数列の和の公式
    初項 a, 公比 r の等比数列の初項から第n項までの和を Sn とすると
    r != 1 => Sn = a(1 - r^n) / (1 - r) = a(r^n - 1) / (r - 1)
    r = 1  => Sn = na
     */

    /*
    Ai - Aj が X の倍数である <=> AiをXで割った余りとAjをXで割った余りが一致する
     */

    /*
    覚えておくべき素数一覧
    2, 3, 5, 7, 11, 13, 101, 127, 10007, 100003, 1000003, 10000019, 100000007,
    167772161, 469762049, 924844033, 998244353, 998244853, 1000000007, 1000000009,
    1012924417, 1224736769, 2147483647, 2305843009213693951
     */

    /*
    Long.MAX_VALUE = 9223372036854775807 (約 9*10^18)
    Integer.MAX_VALUE = 2147483647 (約 2*10^9)
     */

    /*
    平方根の計算なので BigDecimalクラスを使うときは MathContext.DECIMAL128 を引数として使う
    BigDecimal a = new BigDecimal(in.next()).sqrt(MathContext.DECIMAL128);
     */

    /*
    ３点 A(0,0), B(x1,y1), C(x2,y2)が同一直線上にあるかは、ABとACの傾きが等しいかで判定できる
    y1/x1 = y2/x2 で判定すると0除算が発生するため、両辺にx1x2を掛けて、x2y1 = x1y2で判定すると良い
     */

    /*
    A xor C = B <=> A xor B = C
     */

    /*
    木の直径を求める問題で頂点数 25000の時、DFSで実装した場合スタックオーバーフローした
    (https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/5/GRL_5_A)
     */
}

/* start pair
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
    // sorting list of pair by first element then second element
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
    public static <U extends Comparable<U>, V extends Comparable<V>> Pair<U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
} // end pair
 */
