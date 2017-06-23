package ayonel_26_RemoveDuplicatesFromSortedArray;

/**
 * RemoveDuplicate
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-14 20:39
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public static  int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return n;
        int id = 1;
        for(int i = 1; i < n; ++i)
            if(nums[i] != nums[i-1])
                nums[id++] = nums[i];
        return id;

    }

    public static void main(String[] args) {
        int a[] = {1,1,2};
        Solution.removeDuplicates(a);
    }
}