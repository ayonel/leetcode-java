package 丢失的三个数;

/**
 * @author ayonel
 * @create 2017-08-29 15:30
 * @blog https://ayonel.me
 **/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        int[] nums = new int[10000+1];

        String ans = "";

        for (int i = 0; i < array.length; i++) {
            nums[Integer.parseInt(array[i])] = 1;
        }

        for (int i = 1; i <= 10000; i++) {
            if (nums[i] == 0){
                ans+=i;
            }
        }

        System.out.println(Long.parseLong(ans)%7);


    }
}
