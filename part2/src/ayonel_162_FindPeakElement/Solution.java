package ayonel_162_FindPeakElement;

/**
 * @author ayonel
 * @create 2017-06-30 21:04
 * @blog https://ayonel.me
 * 解题思路：二分，因为要求局部极大值，反正就找最大的就行了
 **/
public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high) {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,1};
        System.out.println(new Solution().findPeakElement(a));
    }
}
