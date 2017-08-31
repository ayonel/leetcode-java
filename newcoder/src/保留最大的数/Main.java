package 保留最大的数;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-28 11:11
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int cnt = sc.nextInt();
        int curCnt = 0;
        int n = number.length();
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (number.charAt(i) > number.charAt(i-1)){
                curCnt++;
            } else{
                str.append(number.charAt(i-1));
            }
            if (curCnt == cnt){
                str.append(number.substring(i, n));
                System.out.println(str.toString());
                return;
            }
        }
        str.append(number.charAt(n-1));
        while (curCnt < cnt){
            str.replace(str.length()-1, str.length(), "");
            curCnt++;
        }
        System.out.println(str.toString());


    }
}
