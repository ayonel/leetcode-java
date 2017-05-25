/**
 * @author ayonel
 * @create 2017-05-24 13:58
 * @blog https://ayonel.me
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class Search2dimArray {
    //先确定有可能在哪儿些行，再确定在哪一列
    public boolean Find(int target, int [][] array) {
        int m = array[0].length;
        int n = array.length;

        if (m == 0) return false;
        for(int i = 0; i < n; i++) {
            if(target == array[i][0] || target == array[i][m-1])
                return true;
            if(target > array[i][0] && target < array[i][m-1]) {
                int result = bsearch(target, array[i]);
                if (result != -1)
                    return true;
            }

        }

        return false;

    }

    private int bsearch(int target, int[] nums){
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int m = (lo + hi) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                lo = m+1;
            else
                hi = m-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {{0,7,8},{2,8,9},{3,10,11}};
        Search2dimArray s = new Search2dimArray();
        System.out.println(s.Find(10,a));
    }


}
