package ayonel_263_UglyNumber;

/**
 * @author ayonel
 * @create 2017-07-11 16:10
 * @blog https://ayonel.me
 * 只有2，3，5这三个质因数，不存在其他质因数，一直除这三，顺序不重要，知道不能证书
 **/
public class Solution {
    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num<=0) return false;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        while(num%2==0) num=num>>1;

        return num==1;

    }
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(7));
    }
}
