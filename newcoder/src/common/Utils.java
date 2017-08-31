package common;

/**
 * @author ayonel
 * @create 2017-08-21 14:06
 * @blog https://ayonel.me
 **/
public class Utils {
//    public static void print(int[][] dp) {
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }

    public static void print(long[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
