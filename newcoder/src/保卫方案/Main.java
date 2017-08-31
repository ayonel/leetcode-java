package 保卫方案;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-08-29 17:05
 * @blog https://ayonel.me
 * 过了90，内存超限
 * 不用栈，直接n^2遍历
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

//        HashSet<String> set = new HashSet<>();
        int[][] dp = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.clear();
            for (int j = 1; j < n ; j++) {
                if (nums[(i+j)%n] > nums[i]){
                    if ((i+j)%n >= i){
                        dp[i][(i+j)%n] = 1;
                    }else{
                        dp[(i+j)%n][i] = 1;
                    }
                    break;
                }
                if (stack.isEmpty()||nums[(i+j)%n]>=stack.peek()){
                    stack.push(nums[(i+j)%n]);
                    if ((i+j)%n >= i){
                        dp[i][(i+j)%n] = 1;
                    }else{
                        dp[(i+j)%n][i] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            stack.clear();
            for (int j = 1; j < n ; j++) {
                if (nums[(i-j+n)%n] > nums[i]){
                    if ((i-j+n)%n >= i){
                        dp[i][(i-j+n)%n] = 1;
                    }else{
                        dp[(i-j+n)%n][i] = 1;
                    }
                    break;
                }
                if (stack.isEmpty()||nums[(i-j+n)%n]>=stack.peek()){
                    stack.push(nums[(i-j+n)%n]);
                    if ((i-j+n)%n >= i){
                        dp[i][(i-j+n)%n] = 1;
                    }else{
                        dp[(i-j+n)%n][i] = 1;
                    }
                }
            }

        }

        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = 1;
        }
        dp[0][n-1] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (dp[i][j] == 1)
                    sum++;
            }
        }

//        System.out.println(set);
        System.out.println(sum);

    }
}
