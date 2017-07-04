package ayonel_204_CountPrimes;

/**
 * @author ayonel
 * @create 2017-07-04 17:08
 * @blog https://ayonel.me
 * 判断质数：可以有个trick //不在6的倍数两侧的一定不是质数
 * 标准答案：这道题只是求出小于N的质数的个数，可以在求小的数之前，排除一些合数,
 * 这个解法的思路是先求出所有包含2，3，4，。。。的因数的合数，然后排除，剩下的肯定是质数

 **/
public class Solution {
    public int countPrimesStandard(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
    public  int countPrimes(int n) {
        if(n<=2)
            return 0;
        if (n==3)
            return 1;
        int res = 1;
        for(int i =3; i < n; i++) {
            if (isPrime(i))
                res+=1;
        }

        System.out.println(res);
        return res;

    }
    boolean isPrime( int num )
    {
        //两个较小数另外处理
        if(num ==2|| num==3 )
            return true ;
        //不在6的倍数两侧的一定不是质数
        if(num %6!= 1&&num %6!= 5)
            return false ;
        int tmp = (int)Math.sqrt( num);
        //在6的倍数两侧的也可能不是质数
        for(int i= 5;i <=tmp; i+=6 )
            if(num %i== 0||num %(i+ 2)==0 )
                return false ;
        //排除所有，剩余的是质数
        return true ;
    }
    public static void main(String[] args) {
        new Solution().countPrimesStandard(100);
    }
}
