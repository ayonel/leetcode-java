package 微信红包;

/**
 * @author ayonel
 * @create 2017-08-27 20:36
 * @blog https://ayonel.me
 **/
import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int count = 1;
        int pre = gifts[0];
        for (int i = 1; i < n; i++) {
            if (count == 0){
                pre = gifts[i];
                count = 1;
                continue;
            }
            if (gifts[i] == pre){
                count++;
            } else{
                count--;
            }
        }
        int sum = 0;


        for (int i = 0; i < n; i++) {
            if (pre == gifts[i]){
                sum++;
            }
        }

        if (sum > n/2)
            return pre;
        else
            return 0;

    }

    public static void main(String[] args) {


    }
}
