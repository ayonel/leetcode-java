package 构造回文;
import java.util.*;
/**
 * @author ayonel
 * @create 2017-08-26 20:03
 * @blog https://ayonel.me
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            char[] array = input.toCharArray();
            char[] copy = reverse(array);
            int n = array.length;
            int[][] dp = new int[n][n];

            dp[0][0] = (array[0]==copy[0])? 1:0;
            for (int i = 1; i < n; i++) {
                if (copy[i] == array[0]){
                    dp[0][i] = 1;
                }else{
                    dp[0][i] = dp[0][i-1];
                }
                if (array[i] == copy[0]){
                    dp[i][0] = 1;
                }else{
                    dp[i][0] = dp[i-1][0];
                }

            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (array[i] == copy[j]){
                        dp[i][j] = max(dp[i-1][j-1]+1, dp[i-1][j], dp[i][j-1]);
                    } else{
                        dp[i][j] = max(dp[i-1][j], dp[i][j-1],dp[i-1][j-1]);
                    }
                }
            }
            System.out.println(n-dp[n-1][n-1]);
        }

    }

    public static int max(int x, int y, int z){
        return Math.max(x, Math.max(y,z));
    }


    public static char[] reverse(char[] array){
        char[] copy = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[array.length-1-i] = array[i];
        }
        return copy;
    }
    public static void print(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
