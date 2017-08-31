package 异或;

/**
 * @author ayonel
 * @create 2017-08-22 13:26
 * @blog https://ayonel.me
 **/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] >= m){
                    count++;
                    continue;
                }
                if((nums[i] ^ nums[j]) > m)
                    count++;
            }
        }

        System.out.println(count);


    }
}
