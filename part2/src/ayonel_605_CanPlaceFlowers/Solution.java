package ayonel_605_CanPlaceFlowers;

/**
 * @author ayonel
 * @create 2017-07-24 14:19
 * @blog https://ayonel.me
 * 解题思路：先考虑一种特殊情况，花园大小为1
 * 之后再遍历花园，如果前中后都为0，则可以放一盘花，将n--; 否则寻找下一个能放花的位置，最后看
 * n是否等于0
 **/
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if (size == 1 ){
            return n <= (flowerbed[0]^1);
        }


        for(int i = 0; i < size; i++) {
            if (n == 0)
                break;
            if (i-1>= 0 && i+1 < size){
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }

            if (i == 0 && i+1 < size && flowerbed[i]==0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
            }

            if (i == size-1 && i-1 >= 0 && flowerbed[i]==0 && flowerbed[i-1] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }

        return n==0;
    }

    public static void main(String[] args) {
        int nums[] ={0,0};
        System.out.println(new Solution().canPlaceFlowers(nums, 1));
    }
}
