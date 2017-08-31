package Fibonacci数列;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-21 20:34
 * @blog https://ayonel.me
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fib1 = 0, fib2=1, next=fib1+fib2;
        while (next <= n){
            fib1 = fib2;
            fib2 = next;
            next = fib1+fib2;
        }
        System.out.println(Math.min(Math.abs(next-n), Math.abs(fib2-n)));

    }
}
