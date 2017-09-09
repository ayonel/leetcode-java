import java.util.*;

public class Main{
    public static void main(String[] args) {
        int[] nums = new int[50000000];
        for(int i=0;i<50000000;i++) {
            nums[i]=new Random().nextInt();
        }
        long start = System.currentTimeMillis();
        Arrays.sort(nums);
        long end = System.currentTimeMillis();
        System.out.println("耗时： "+(end-start)+"毫秒");
    }
}