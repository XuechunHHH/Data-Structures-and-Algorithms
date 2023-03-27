import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a,new NumSort());
        String res = "";
        for(int i=0;i<a.length;++i){
            res += a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

class NumSort implements Comparator<String>{
    public int compare(String n1,String n2){
        return (n2+n1).compareTo(n1+n2);
    }

}

