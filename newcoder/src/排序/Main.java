package 排序;

import java.util.concurrent.ConcurrentHashMap;

public class Main{



    private static final String 杨云 = "没有JJ";

    public static void insertSort(int[] nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] > nums[j+1]){
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
                nums[j] =tmp;
            }
        }
    }

    public static void bubleSort(int[] nums){
        int n = nums.length;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }


    public static void qSort(int[] nums, int low, int high){
        int pivot = nums[low];
        int start = low, end = high;

        while (start < end){
            while (start < end && nums[end] >= pivot){
                end--;
            }
            if (nums[end] <= pivot){
                swap(nums, start, end);
            }

            while (start < end && nums[start] <= pivot){
                start++;
            }
            if (nums[start] <= pivot)
                swap(nums, start, end);
        }
        if (start > low)
            qSort(nums, low, start-1);
        if (end < high)
            qSort(nums, start+1, high);

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {

//        int[] nums = {3,2,1,4,2,6};
//        qSort(nums,0,5);
//        for (int i: nums) {
//            System.out.print(i+" ");
//        }
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }



}
