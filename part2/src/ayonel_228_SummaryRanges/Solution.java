package ayonel_228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-09 17:18
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list =new ArrayList<>();
        int length = nums.length;
        if (length == 0)
            return list;
        int start = nums[0];
        int end = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i]-1 == nums[i-1] || nums[i] == nums[i-1])
                end = nums[i];
            else {
                if (start == end) {
                    list.add(""+start);
                } else {
                    list.add(start+"->"+end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) {
            list.add(""+start);
        } else {
            list.add(start+"->"+end);
        }


        return list;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,5,7,8};
        System.out.println(new Solution().summaryRanges(nums));
    }
}
