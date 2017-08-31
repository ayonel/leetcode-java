package 小易喜欢的单词;

import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-21 20:19
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char[] array = word.toCharArray();
        int index = 0;
        int n = array.length;
        for (; index < n; index++) {
            if (array[index] < 'A' || array[index] > 'Z')
                break;
        }
        if (index < n) {
            System.out.println("Dislikes");
            return;
        }

        boolean hasContinuous = false;
        for (int j = 1; j < n; j++) {
            if (array[j] == array[j-1]){
                hasContinuous = true;
                break;
            }
        }
        if (hasContinuous){
            System.out.println("Dislikes");
            return;
        }

        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                char x = array[i];
                char y = array[j];
                boolean hasX = false;
                boolean hasY = false;
                for (int k = j+1; k < n-1; k++) {
                    if (array[k] == x){
                        hasX = true;
                        for (int l = k+1; l < n; l++) {
                            if (array[l] == y){
                                hasY = true;
                                break;
                            }
                        }

                    }
                }

                if (hasX && hasY){
                    System.out.println("Dislikes");
                    return;
                }

            }
        }

        System.out.println("Likes");


    }


}
