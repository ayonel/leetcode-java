package 数字游戏;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-21 20:41
 * @blog https://ayonel.me
 * 通过率80%
 * 如果深搜出所有可能组成的数组，那样应该可以
 *
 * 第二种方法是先dfs出所有可能的和，然后再从1 找到 sum+1， 看谁先不在
 **/
public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//            sum += nums[i];
//        }
//        Arrays.sort(nums);
//
//        for (int i = nums[0]; i <= sum ; i++) {
//            boolean find = false;
//            for (int j = 0; j < n; j++) {
//                if (contains(nums, j, i)){
//                    find = true;
//                }
//            }
//            if (!find){
//                System.out.println(i);
//                return;
//            }
//        }
//        System.out.println(sum+1);
//
//
//    }
//    public static boolean contains(int[] nums, int index, int target){
//        if (nums[index] == target)
//            return true;
//        if (index == nums.length)
//            return false;
//        boolean res = false;
//        for(int i = index+1; i < nums.length; i++){
//            res = res | contains(nums, i, target-nums[index]);
//        }
//        return res;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);

        HashSet<Integer> set  = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(nums, i, set, 0);
        }

        for (int i = 1; i <= sum+1; i++) {
            if (!set.contains(i)){
                System.out.println(i);
                return;
            }
        }


    }

    private static void dfs(int[] nums, int index, HashSet<Integer> set, int cur) {
        cur += nums[index];
        set.add(cur);
        for (int i = index+1; i < nums.length; i++) {
            dfs(nums, i, set, cur);
        }
    }
}
