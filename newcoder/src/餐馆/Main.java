package 餐馆;

import java.util.*;
/**
 * @author ayonel
 * @create 2017-08-29 22:18
 * @blog https://ayonel.me
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int desk[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            desk[i][0] = sc.nextInt();
            desk[i][1] = 0;
        }

        int[][] guest = new int[m][2];
        for (int i = 0; i < m; i++) {
            guest[i][0] = sc.nextInt();
            guest[i][1] = sc.nextInt();
        }

        Arrays.sort(desk, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return new Integer(o1[0]).compareTo(o2[0]);
            }
        });
        Arrays.sort(guest, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]){
                    return -1;
                }
                if (o1[1] < o2[1]){
                    return 1;
                }
                if (o1[0] > o2[0]){
                    return -1;
                }

                if (o1[0] < o2[0]){
                    return 1;
                }
                return 0;
            }
        });

        int count = 0;
        int index = 0;
        long sum = 0;
        while (count < n && index < m){
            int pos = bs(desk, guest[index][0]);
            if (pos < n && desk[pos][1] == 0){
                sum += guest[index][1];
                desk[pos][1] = 1;
                count++;
                index++;
                continue;
            } else if (pos < n && desk[pos][1] == 1){
                int j = pos+1;
                for(; j < n; j++){
                    if (desk[j][1] == 0){
                        desk[j][1] = 1;
                        sum += guest[index][1];
                        count++;
                        index++;
                        break;
                    }
                }
                if (j == n){
                    index++;
                }

            } else {
                index++;
            }

        }
        System.out.println(sum);
    }

    private static int bs(int[][] num, int tar){
        int low=0;
        int high=num.length-1;
        int mid=0;
        while(low<=high){
            mid=(high+low)>>1;
            if(num[mid][0]>=tar)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

}
