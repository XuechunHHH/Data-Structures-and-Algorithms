import java.util.*;

public class FibonacciHuge {
    private static long pisano(long m) {
        long pre = 0;
        long cur = 1;
        long tmp_pre;

        for (long i = 0; i < m * m; ++i) {
            tmp_pre = pre;
            pre = cur;
            cur = (tmp_pre + cur) % m;

            if (pre == 0 && cur == 1) {
                return i + 1;
            }
        }
        return 0;
    }

    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        if (m <= 1) System.out.println(0);
        long p = pisano(m);
        System.out.println(getFibonacciHuge(n % p, m));
    }
}

