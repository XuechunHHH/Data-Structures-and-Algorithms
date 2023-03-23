import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;
        int max1_idx = -1;
        for (int i = 0; i < n; ++i) {
            if (max1_idx == -1 || numbers[i] > numbers[max1_idx]){
                max1_idx = i;
            }
        }

        int max2_idx = -1;
        for (int i = 0; i < n; ++i) {
            if ((max2_idx == -1 || numbers[i] > numbers[max2_idx]) && i != max1_idx){
                max2_idx = i;
            }
        }

        return (long) numbers[max1_idx] * (long) numbers[max2_idx];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
