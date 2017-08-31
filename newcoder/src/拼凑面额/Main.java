package 拼凑面额;

/**
 * @author ayonel
 * @create 2017-08-29 14:38
 * @blog https://ayonel.me
 * 动归，先推出用全用1 的 i += i-1;
 * 然后推出用5的   i+=i-5;
 **/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();

        int[]coins= {1,5,10,20,50,100};//存储能用的硬币面额

        long[]dp=new long[n+1];
        dp[0]=1L;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < n+1; j++) {
                if(j>=coins[i]) {
                    dp[j]+=dp[j-coins[i]];
                }
            }
        }
        System.out.println(dp[n]);
    }

}