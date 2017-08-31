package 合唱团;
import java.util.*;

import static common.Utils.print;


/**
 * @author ayonel
 * @create 2017-08-21 13:58
 * @blog https://ayonel.me
 * 解题思路：
 * 动归，维护一个最大值数组，最小值数组，
 * max[i][j]存放的是以学生j结尾的，i个最大乘机；min[i][j]存放的是以学生j结尾的，i个最小乘机；
 * 对于每个i，j 需要从j开始向前最大遍历d个学生，算出来student[j]*min[i][k] student[j]*max[i][k]
 * 以及dp[i][j-1]作为当前dp[i][j]的值，
 * max 始终保存以当前学生结尾的最大值，min 始终保存以当前学生结尾的最小值
 * *
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] student = new long[n];
        for(int i = 0; i < n; i++)
            student[i] = sc.nextLong();
        int k = sc.nextInt();
        int d = sc.nextInt();

        long[][] max = new long[k][n];
        long[][] min = new long[k][n];
        long[][] dp = new long[k][n];
        for (int i = 0; i < n; i++) {
            max[0][i] = student[i];
            min[0][i] = student[i];
            if (i == 0)
                dp[0][i] = student[i];
            else
                dp[0][i] = Math.max(dp[0][i-1], student[i]);
        }
        for (int i = 1; i < k; i++) {
            max[i][0] = student[0];
            dp[i][0] = student[0];
        }

        for (int i = 1; i < k ; i++) {
            for (int j = 1; j < n; j++) {
                for(int z = 1; z <= d && j-z >= 0; z++){
                    dp[i][j] = max(dp[i][j], max[i-1][j-z]*student[j], min[i-1][j-z]*student[j]);
                    max[i][j] = max(max[i-1][j-z]*student[j], max[i][j], min[i-1][j-z]*student[j]);
                    min[i][j] = min(min[i-1][j-z]*student[j], min[i][j], max[i-1][j-z]*student[j]);

                }
                dp[i][j] = Math.max(dp[i][j-1], dp[i][j]);
            }
        }
        print(dp);
        System.out.println(dp[k-1][n-1]);
    }

    public static long max(long x, long y, long z){
        return Math.max(x, Math.max(y,z));
    }
    public static long min(long x, long y, long z){
        return Math.min(x, Math.min(y,z));
    }


}
