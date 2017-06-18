package classic;

/**
 * Reverse pair
 *
 * @author ayonel
 * @create 2017-06-17 21:01
 * @blog https://ayonel.me
 * 归并排序，动归也能解，但是超了
 **/
public class ReversePair {
    public int InversePairs(int [] array) {
        int n = array.length;
        if (array.length <= 1)
            return 0;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i-1]) {
                dp[i-1][i] = 1;
            }
        }
        print(dp);
        System.out.println("------------");

        for (int gap = 2; gap < n; gap++) {
            for(int i = 0; i + gap < n; i++) {
                if (array[i] > array[i+gap])
                    dp[i][i+gap] = dp[i+1][i+gap] + dp[i][i+gap-1] + 1 - dp[i+1][i+gap-1];
                else
                    dp[i][i+gap] = dp[i+1][i+gap] + dp[i][i+gap-1] - dp[i+1][i+gap-1];
            }
        }
        print(dp);
        return dp[0][n-1];

    }


    public void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {2,5,0,1,1};
        new ReversePair().InversePairs(array);
    }

    
}
