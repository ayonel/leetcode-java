package 买苹果;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-28 20:45
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = n/8;
        //n==6
        int mod = n%8;
        if ((mod&1) == 1) {
            System.out.println(-1);
        }else{
           if (mod==2){
               if (ans >= 2){
                   System.out.println(ans+1);
               } else{
                   System.out.println(-1);
               }
           }
            if (mod==4){
                if (ans >= 1){
                    System.out.println(ans+1);
                } else{
                    System.out.println(-1);
                }

            } else{
                System.out.println(ans+1);
            }

        }
    }

}
