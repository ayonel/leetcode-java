package classic;

/**
 * @author ayonel
 * @create 2017-06-18 13:43
 * @blog https://ayonel.me
 * 统计一个数字在排序数组中出现的次数。

 **/
public class CountAppearTime {
    public int GetNumberOfK(int [] array , int k) {
        int res = 0;
        int findIndex = bsearch(array, 0, array.length-1, k);
//        System.out.println("dd");
        if(findIndex != -1){
            res = 1;
            int i = findIndex-1, j = findIndex+1;
            while(i >= 0 ){
                if(array[i] == k)
                    res+=1;
                else
                    break;
                i--;
            }

            while(j < array.length){
                if(array[j] == k)
                    res+=1;
                else
                    break;
                j++;
            }
        }
        return res;

    }

    public int bsearch(int[] array, int start, int end, int target) {

        while(start <= end) {
            int mid = (start+end) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] < target)
                start = mid + 1;
            if (array[mid] > target)
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3};
        System.out.println(new CountAppearTime().GetNumberOfK(a, 3));
    }
}
