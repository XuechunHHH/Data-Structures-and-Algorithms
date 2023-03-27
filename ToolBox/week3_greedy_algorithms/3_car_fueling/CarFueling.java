import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops, int cnt, int idx, int toDist) {
        if (dist<=tank) return cnt;
        if ( (idx >= 0 && idx+1 <= stops.length-1 && stops[idx+1]-stops[idx]>tank) ||
                (idx < 0 && stops[idx+1] >tank) || (idx+1 > stops.length-1 && dist>tank)) return -1;

        if(idx != -1){
            int start = idx;
            while (idx + 1<stops.length && stops[idx+1] - stops[start]<= tank){
                idx ++;
            }
        }else {
            while (idx + 1<stops.length && stops[idx+1] <= tank){
                idx ++;
            }
        }

        cnt ++;
        return computeMinRefills(toDist-stops[idx],tank,stops,cnt,idx,toDist);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops, 0, -1,dist));
    }
}
