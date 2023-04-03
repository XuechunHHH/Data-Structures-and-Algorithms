import java.util.*;
import java.io.*;

public class MajorityElement {
    static int binarySearchFirst(int[] a, int x, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (a[mid] == x && (mid == 0 || a[mid-1]!=x)) return mid;
        else if (a[mid] < x) {
            return binarySearchFirst(a, x, mid + 1, right);
        } else {
            return binarySearchFirst(a, x, left, mid - 1);
        }
    }

    static int binarySearchLast(int[] a, int x, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (a[mid] == x && (mid == a.length-1 || a[mid+1]!=x)) return mid;
        else if (a[mid] > x) {
            return binarySearchLast(a, x, left, mid-1);
        } else {
            return binarySearchLast(a, x, mid+1, right);
        }
    }
    private static int getMajorityElement(int[] a) {
        Arrays.sort(a);
        for (int i=0;i<a.length;++i){
            int first = binarySearchFirst(a,a[i],0,a.length-1);
            int last = binarySearchLast(a,a[i],0,a.length-1);
            if (last-first+1>a.length/2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

