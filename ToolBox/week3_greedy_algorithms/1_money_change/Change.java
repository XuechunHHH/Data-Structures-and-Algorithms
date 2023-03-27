import java.nio.channels.AsynchronousChannelGroup;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] changes = {10,5,1};
        int total = m;
        int cnt = 0;
        for (int i=0;i<changes.length;++i){
            cnt += total / changes[i];
            total = total % changes[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

