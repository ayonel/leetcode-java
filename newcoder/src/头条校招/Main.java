package 头条校招;

/**
 * @author ayonel
 * @create 2017-08-22 11:26
 * @blog https://ayonel.me
 **/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        Arrays.sort(weight);
        int cur = 1;
        int pre = weight[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (cur == 0){
                pre = weight[i];
                cur++;
                continue;
            }

            if (weight[i]-pre <= 10){
                cur+=1;
                pre = weight[i];
            }
            if (weight[i]-pre > 10){
                pre = weight[i]+10;
                count++;
                cur+=1;
                i--;
            }

            if (cur == 3){
                cur=0;
            }

        }

        if (cur > 0 && cur < 3)
            count+=3-cur;

        System.out.println(count);


    }
}
