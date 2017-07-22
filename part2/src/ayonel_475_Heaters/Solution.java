package ayonel_475_Heaters;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-21 17:37
 * @blog https://ayonel.me
 **/
public class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0, i = 0, j = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        while (i < houses.length) {
            if(j < heaters.length-1 && houses[i] < heaters[j+1]) {
                int cur = Math.min(Math.abs(heaters[j+1]-houses[i]), Math.abs(heaters[j]-houses[i]));
                radius = Math.max(cur, radius);
                i++;
            } else if (j < heaters.length-1 && houses[i] >= heaters[j+1]){
                j++;
            } else {
                radius = Math.max(radius, Math.abs(heaters[j]-houses[i]));
                i++;
            }
        }
        return radius;
    }

    public int findRadiusStandard(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
//        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
//        int[] houses = {5};
//        int[] heaters = {3,6};
//
//        System.out.println(new Solution().findRadiusStandard(houses, heaters));
        System.out.println(new Solution().findComplement(2));
    }
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        char[] strA = str.toCharArray();
        int len = strA.length;
        for(int i=0; i <len; i++){
            if(str.charAt(i) == '0')
                strA[i]='1';
            if(str.charAt(i) == '1')
                strA[i]='0';
        }
        int res = 0;
        for(int i = 0; i < len; i++) {
            if (strA[len-1-i] == '1')
                res += Math.pow(2, i);

        }
        return res;

    }

}
