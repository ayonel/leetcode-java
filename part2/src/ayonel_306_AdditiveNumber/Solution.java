package ayonel_306_AdditiveNumber;

/**
 * @author ayonel
 * @create 2017-07-25 13:08
 * @blog https://ayonel.me
 **/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(add(1,0));
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE-1);
    }
    public static int add(int a, int b){
        while (a+b>0)
        {
            a+=1;
            b-=1;
            if (a == Integer.MAX_VALUE)
                System.out.println(b);
        }
        return a+b;
    }
}
