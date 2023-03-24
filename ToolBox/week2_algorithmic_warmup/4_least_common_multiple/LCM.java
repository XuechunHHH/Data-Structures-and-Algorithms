import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
    int big = Math.max(a,b);
    int small = Math.min(a,b);
    int temp;
    while (big % small != 0){
      temp = big % small;
      big = small;
      small = temp;
    }
    return (long) a *(long) b / (long) small;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
