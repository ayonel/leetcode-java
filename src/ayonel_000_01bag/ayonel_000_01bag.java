package ayonel_000_01bag;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * Created by dimera on 2017/4/12.
 * 0, 1背包问题
 */
public class ayonel_000_01bag {
    public static void main(String[] args) {
        int[] W = {2,2,6,5,4};
        int[] V = {6,3,5,4,6};
        int capacity = 10;
        bag_no_recur_optimized_zl(W,V,capacity);
        System.out.println("-----------------");
        bag_no_recur(W,V,capacity);

    }

    public static int solve(int i, int j, int[] W, int[] V) {
        if (i < 0)
            return 0;
        if (W[i] > j)
            return solve(i-1, j, W, V);
        else
            return max(solve(i-1, j, W, V), V[i] + solve(i-1, j-W[i], W, V));
    }
    public static int max(int i, int j) {
        return i > j ? i : j;
    }

    public static int bag_no_recur(int[] W, int[] V, int capacity) {
        int count = W.length;
        int[][] result = new int[count][capacity];

        for (int i = count-1; i >= 0; i--) {
            for(int j = 0; j < capacity; j++) {
                if (j < W[i] && i == count-1) {
                    result[i][j] = 0;
                } else if (j >= W[i] && i == count-1) {
                    result[i][j] = V[i];
                }
                if (j < W[i] && i != count-1) {
                    result[i][j] = result[i + 1][j];
                } else if (j >= W[i] && i != count-1) {
                    result[i][j] = max(result[i + 1][j], V[i] + result[i + 1][j - W[i]]);
                }
            }
        }

        for (int i=0;i<count;i++){
            for (int j=0;j<capacity;j++){
                System.out.print(result[i][j]+",");
            }
            System.out.println("\n");
        }

        return result[0][capacity-1];

    }

    public static int bag_no_recur_optimized(int[] W, int[] V, int capacity) {
        int count = W.length;
        int[][] result = new int[count+1][capacity];

        for (int i = count-1; i >= 0; i--) {
            for(int j = 0; j < capacity; j++) {
                if (W[i] < j) {
                    result[i][j] = max(result[i+1][j], V[i] + result[i+1][j-W[i]]);
                } else {
                    result[i][j] = result[i+1][j];
                }

            }
        }

        for (int i=0;i<=count;i++){
            for (int j=0;j<capacity;j++){
                System.out.print(result[i][j]+",");
            }
            System.out.println("\n");
        }

        return result[0][capacity-1];

    }
    public static int bag_no_recur_optimized_zl(int[] W, int[] V, int capacity) {
        int count = W.length;
        int[][] result = new int[count+1][capacity+1];

        for (int i = 1; i <=count; i++) {
            for(int j = 0; j <= capacity; j++) {
                if (W[i-1] <= j) {
                    result[i][j] = max(result[i-1][j-W[i-1]]+V[i-1],result[i-1][j]);
                } else{
                    result[i][j] = result[i-1][j];
                }
            }
        }

        for (int i=0;i<=count;i++){
            for (int j=0;j<capacity;j++){
                System.out.print(result[i][j]+",");
            }
            System.out.println("\n");
        }

        return result[0][capacity];
    }


}