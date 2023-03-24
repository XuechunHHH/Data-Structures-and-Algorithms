import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
    int big = Math.max(a,b);
    int small = Math.min(a,b);
    int temp;
    while (big % small != 0){
      temp = big % small;
      big = small;
      small = temp;
    }
    return small;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
