package 马戏团;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-08-28 16:20
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> peoples = new ArrayList<>();
        ArrayList<ArrayList<Integer>> copy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());

            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(list.get(0));
            list1.add(list.get(1));
            list1.add(list.get(2));
            peoples.add(list);
            copy.add(list1);
        }

        Collections.sort(peoples,new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        Collections.sort(peoples,new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });




        //求最长递增子序列,解法为动归，对于一个无序数组，其最长递增子序列为与其排好序的数组的最长公共子序列
        int[][] dp = new int[n][n];
        dp[0][0] = (peoples.get(0).get(2).equals(copy.get(0).get(2)))? 1:0;

        for (int i = 1; i < n; i++) {
            if (copy.get(i).get(2).equals(peoples.get(0).get(2))){
                dp[0][i] = 1;
            }else{
                dp[0][i] = dp[0][i-1];
            }
            if (peoples.get(i).get(2).equals(copy.get(0).get(2))){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (peoples.get(i).get(2).equals(copy.get(j).get(2))){
                    dp[i][j] = max(dp[i-1][j-1]+1, dp[i-1][j], dp[i][j-1]);
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
    public static int max(int x, int y, int z){
        return Math.max(x, Math.max(y,z));
    }

}
