import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] vpw = new double[values.length];
        for (int i=0;i<values.length;++i){
            vpw[i] = (double) values[i] / weights[i];
        }
        for (int j=0;j<vpw.length;++j){
            if (capacity==0) return value;
            int i = getLargestvpw(vpw,weights);
            int amount = Math.min(capacity,weights[i]);
            value += amount * vpw[i];
            weights[i] -= amount;
            capacity -= amount;
        }
        return value;
    }

    private static int getLargestvpw(double[] vpw,int[] weights){
        int idx = 0;
        for (int i=1;i<vpw.length;++i){
            if (weights[i] > 0){
                if (vpw[i] > vpw[idx]){
                    idx = i;
                }
            }
        }
        return idx;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
