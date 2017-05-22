package ayonel_41_FirstMissingPositive;

/**
 * First Missing Positive
 *
 * @author ayonel
 * @create 2017-05-22 21:52
 * @blog https://ayonel.me
 *
 * 解题思路：桶排序 空间开销较大
 **/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max)
                max = nums[i];
        }

        if (max == -1) {
            return 1;
        }

        int[] bucket = new int[max+1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                bucket[nums[i]] = 1;  //用1填充
        }
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == 0)
                return i;
        }

        return bucket.length;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {-1,100,1,2,3,0,4};
        System.out.println(s.firstMissingPositive1(a));
    }


    //O(1)空间 O(n)的更好算法
    //不停的swap 保证数组的序列是{1，2，3，。。。。}

    public int firstMissingPositive1(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
