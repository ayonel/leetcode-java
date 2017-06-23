package ayonel_60_PermutationSequence;

/**
 * 60. Permutation Sequence
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-15 14:05
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：二找，一换，一翻转，但是效率有些慢
 * 没有必要求出所有的
 *
 **/
public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        //数组构造好了

        for (int index= 1; index < k; index++) {
            //生成下一个有序排列
            //找到了最后一个升序位置i，x=a[i]
            int i = n-2;
            for (; i >= 0; i--) {
                if (nums[i] < nums[i+1])
                    break;
            }
            //找到i右边最后一个比a[i]大的位置
            int j = n-1;
            for (; j > i; j--) {
                if (nums[j] > nums[i])
                    break;
            }

            //交换i和j的位置
            swap(nums, i, j);
            //翻转i+1位到最后的子串
            reverse(nums, i+1, n-1);

            for (int l = 0; l < n; l++) {
                System.out.print(nums[l]+" ");
            }
            System.out.println();

        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(""+nums[i]);
        }
        return str.toString();

    }


    public void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        for (int start = i, end =j; start < end; start++, end--) {
            swap(nums, start, end);
        }

    }


    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3,5));
    }
}
