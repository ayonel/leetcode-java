package ayonel_31_NextPermutation;

/**
 * Next Permutation
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-21 17:35
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：i=最后，i--一直往前找，如果一直是升序，则不断i--;一旦找到了一个i，nums[i-1]<nums[i]了，也就是打破了升序，则
 * 把i~end之间的数组反转，然后在从这个升序的子数组中找到第一个大于nums[i-1]的值，把它与i的位置交换，返回
 * 如果能执行到出循环，说明该数组是一个天然的降序数组，则反转整个数组
 **/
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int end  = i;
        for (; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                revease(nums, i, end);
                for (int j = i ; j <= end; j++) {
                    if (nums[j] > nums[i-1]) {
                        swap(nums, i-1, j);
                        return;
                    }
                }
            }
        }
        revease(nums, i, end);
    }

    private void swap(int[] nums, int id1, int id2) {
        int tmp;
        tmp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = tmp;
    }

    private void revease(int[] nums, int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3};
        Solution s = new Solution();
        s.nextPermutation(nums);
        for (int item:
             nums) {
            System.out.print(item+",");

        }
    }
}
