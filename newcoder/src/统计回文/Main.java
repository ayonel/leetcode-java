package 统计回文;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-21 19:20
 * @blog https://ayonel.me
 * 节省空间，其实可以直接连接子串，构造新串来判断是否回文
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.next();
        String strB = sc.next();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < strA.length(); i++){
            list.add(strA.charAt(i));
        }
        for(int i = 0; i < strB.length(); i++){
            list.add(strB.charAt(i));
        }
        int n = list.size(), lenA = strA.length(), count = 0;
        if (isParlin(list))
            count++;

        for(int i = 0; i < lenA; i++){
            char c = list.remove(lenA-1-i);
            list.add(n-1-i, c);
            if (isParlin(list))
                count++;
        }
        System.out.println(count);


    }

    public static boolean isParlin(ArrayList<Character> list) {
        int i = 0, j = list.size()-1;
        while (i < j){
            if (list.get(i++) != list.get(j--))
                return false;
        }
        return true;
    }
}
