package ayonel_75_SortColors;

/**
 * Sort Colors
 *
 * @author ayonel
 * @create 2017-05-25 21:31
 * @blog https://ayonel.me
 * 解题思路：快排
 **/
public class Solution {
    public void sortColors(int[] nums) {
        qsort(nums, 0, nums.length - 1);
    }

    public void qsort(int[] a, int low, int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end > start){
            //从后往前比较
            while(end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end] < key){
                swap(a, start, end);
            }
            //从前往后比较
            while(end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start] > key){
                swap(a, start, end);
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start > low) qsort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end < high) qsort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }


    public void swap(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {1,2,0};
        s.sortColorsStandard(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

    // 其实可以不用暴力排序，把0放到最左边，2放到最后边
    public void sortColorsStandard(int[] nums) {
        int i = 0;
        int j = 0;
        for (int k =0; k < nums.length; k++) {
            int v = nums[k];
            nums[k] = 2;
            if(v < 2){
                nums[j] = 1;
                j += 1;
            }
            if(v == 0){
                nums[i] = 0;
                i += 1 ;
            }
        }
    }

}