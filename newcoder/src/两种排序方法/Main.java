package 两种排序方法;

/**
 * @author ayonel
 * @create 2017-08-21 20:03
 * @blog https://ayonel.me
 * 用额外的两个数组，如果像下面这样直接连成串，
 * 像
 *
 * 3
aa
aaaaaaa
aaaaa
 就过不了，直接用数组比较每个元素是否相等

 **/
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
        }
        StringBuilder ori = new StringBuilder();
        for(String str : array)
            ori.append(str);

        Arrays.sort(array);
        StringBuilder lex = new StringBuilder();
        for(String str : array)
            lex.append(str);

        Arrays.sort(array, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if (s1.length() > s2.length())
                    return 1;
                if (s1.length() == s2.length())
                    return 0;
                else
                    return -1;
            }
        });

        StringBuilder len = new StringBuilder();
        for(String str : array)
            len.append(str);

        if (ori.toString().equals(lex.toString()) && ori.toString().equals(len.toString())){
            System.out.println("both");
            return;
        }

        if (ori.toString().equals(lex.toString())){
            System.out.println("lexicographically");
            return;
        }
        if (ori.toString().equals(len.toString())){
            System.out.println("lengths");
            return;
        }
        System.out.println("none");

    }
}
