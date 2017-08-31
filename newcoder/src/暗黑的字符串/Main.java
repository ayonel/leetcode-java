package 暗黑的字符串;



import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-28 20:45
 * @blog https://ayonel.me
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(3*sovle(n));
    }

    public static long sovle(long n){
        if (n == 1)
            return 1;
        if (n==2)
            return 3;
        long last1 = sovle(n-2);
        long  last2 = sovle(n-1);

        return 2*last2+last1;
    }


}

