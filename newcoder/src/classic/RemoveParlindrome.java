package classic;

import java.util.Scanner;

/**
 * 对一个字符串，随机删去一些字符，使之成为回文串，求这些回文串的最大个数。
 */

public class RemoveParlindrome {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
        String line = "axbcba";
        System.out.println(solve(line));

    }

    public static void print(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length; j++) {
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println("*****************");
    }

    public static long solve(String s){
        int length = s.length();
        if (length < 2)
            return length;

        int[][] dp = new int[length][length];
        for (int i = 0; i< length; i++) {
            dp[i][i] = 1;
        }

        for (int k = 1; k < length; k++) {
            for (int i= 0; i+k < length;i++) {
                if (s.charAt(i) == s.charAt(i+k)) {
                    dp[i][i+k] = dp[i][i+k-1]+dp[i+1][i+k];
                } else {
                    dp[i][i+k] = dp[i+1][i+k] + dp[i][i+k-1]-dp[i+1][i+k-1];
                }

                print(dp);
            }
        }

        return dp[0][length-1];

    }

}