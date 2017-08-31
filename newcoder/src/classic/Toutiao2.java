package classic;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-03 16:01
 * @blog https://ayonel.me
 **/
public class Toutiao2 {


    public static void main(String[] args) {

        System.out.println(2^3);
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            int res = 0;
            for(int i = 0 ; i < array.length-1; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (((long)array[i] ^ (long)array[j]) > (long)m)
                        res++;
                }
            }
            System.out.print(res);

        }

    }
}
