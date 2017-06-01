package ayonel_80_RemoveDuplicatesfromSortedArrayII;

/**
 * @author ayonel
 * @create 2017-05-27 21:55
 * @blog https://ayonel.me
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int id = 1;
        int flag = 0;
        int length = nums.length;
        if (length <= 1)
            return length;

        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i-1]){
                nums[id++] = nums[i];
                flag = 0;
            } else {
                if (flag < 1) {
                    nums[id++] = nums[i];
                }
                flag++;
            }
        }

        for (int i = 0; i < length; i++)
            System.out.println(nums[i] + " ");
        System.out.println();
        return id;

    }


    public int removeDuplicatesStandard(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,3,3,4,5};
//        int[] a = {1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicatesStandard(a));
    }
}