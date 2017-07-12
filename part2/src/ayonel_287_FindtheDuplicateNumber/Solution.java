package ayonel_287_FindtheDuplicateNumber;

/**
 * @author ayonel
 * @create 2017-07-11 22:35
 * @blog https://ayonel.me
 * 解题思路：我强无敌
 * 首先，扫一遍数组，没找到一个数，就把以这个数为索引的位置的数+n，这样就造成有些数大于n了
 * 如果定位到某个索引的时候，要给这个索引上的数+n的时候，发现已经大于n了，说明已经找了，返回这个索引。
 * 如果要维持数组不变，返回前，扫一遍数组，对于大于n的数-n，就会还原
 * 另一种解题思路：用快慢指针法（标准）
 **/
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > n) {
                if (nums[nums[i]-n] > n)
                    return nums[i]-n;
                else
                    nums[nums[i]-n] = n+nums[nums[i]-n];
            } else {
                if (nums[nums[i]] > n)
                    return nums[i];
                else
                    nums[nums[i]] = n+nums[nums[i]];
            }

        }
        return 0; //没用
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution().findDuplicate(nums));
    }
}
