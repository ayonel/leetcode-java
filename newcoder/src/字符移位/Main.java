package 字符移位;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-26 21:02
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            char[] array = input.toCharArray();
            int n = array.length;
            char[] copy = new char[n];

            int lowerCount = 0;
            for (int i = 0; i < n; i++){
                if (array[i]>='A' && array[i]<='Z')
                    lowerCount++;
            }
            int i = 0, j = n-lowerCount;
            for(int k = 0; k < n; k++){
                if (array[k]>='A' && array[k]<='Z'){
                    copy[j++] = array[k];
                } else{
                    copy[i++] = array[k];
                }
            }
            System.out.println(String.copyValueOf(copy));


        }
    }
}
