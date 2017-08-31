package 彩色宝石项链;

/**
 * @author ayonel
 * @create 2017-08-28 11:36
 * @blog https://ayonel.me
 **/

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author ayonel
 * @create 2017-08-28 11:11
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            int length = input.length();
            int ans = find(input);
            if (ans == 0){
                System.out.println(ans);
            } else{
                input = input.substring(length/2,length)+input.substring(0,length/2);
                ans = Math.max(ans, find(input));
                System.out.println(ans);
            }
        }

    }
    public static int find(String input){
        int ans = 0;
        int length = input.length();
        int index = 0;
        int curMax = 0;
        if (input.indexOf('A') == -1 || input.indexOf('B') == -1 || input.indexOf('C') == -1
                || input.indexOf('D') == -1 || input.indexOf('E') == -1) {
            return ans;
        }else{
            for (int i = 0; i <= input.length()-5; i++) {
                if (input.charAt(i) == 'A'||input.charAt(i) == 'B'||input.charAt(i) == 'C'
                        ||input.charAt(i) == 'D' || input.charAt(i) == 'E'){
                    String sub = input.substring(i);
                    if (sub.indexOf('A') == -1 || sub.indexOf('B') == -1 || sub.indexOf('C') == -1
                            || sub.indexOf('D') == -1 || sub.indexOf('E') == -1){
                        break;
                    }else{

                        int[] start = new int[5];
                        start[0] = sub.indexOf('A');
                        start[1] = sub.indexOf('B');
                        start[2] = sub.indexOf('C');
                        start[3] = sub.indexOf('D');
                        start[4] = sub.indexOf('E');
                        Arrays.sort(start);
                        curMax = 0;
                        for (int j = 1; j < 5; j++) {
                            if (start[j] - start[j-1] - 1 > curMax){
                                curMax = start[j] - start[j-1] - 1;
                            }
                        }
                        ans = Math.max(ans, length-(start[4]-start[0]+1));
                        ans = Math.max(ans, curMax);
                    }
                }

            }
        }
       return ans;
    }

}

