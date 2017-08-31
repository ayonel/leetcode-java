package 字典序;

/**
 * @author ayonel
 * @create 2017-08-22 13:39
 * @blog https://ayonel.me
 **/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            boolean has = false;
            for(int i = m; i<= n; i++){
                if (isValid(i)){
                    System.out.print(i+" ");
                    has = true;
                }
            }

            if (!has){
                System.out.print("no");
            }



        }

    }

    public static boolean isValid(int num) {
        int sum = 0;
        int copy = num;
        while (num > 0) {
            sum += Math.pow((int)(num % 10), 3);
            num /= 10;
        }
        return sum == copy;

    }

}