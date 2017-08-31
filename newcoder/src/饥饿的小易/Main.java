package 饥饿的小易;

/**
 * @author ayonel
 * @create 2017-08-21 19:52
 * @blog https://ayonel.me
 * 链接：https://www.nowcoder.com/questionTerminal/5ee8df898312465a95553d82ad8898c3
来源：牛客网

核心问题  4x+3和8x+7的数学操作，可以用二进制的左移和补1表示  y = 4*x+3,相当于x的二进制左移2位，然后空位补1，
即原先x的二进制为#####,则y的二进制为#####11， y = 8*x+3,相当于y的二进制左移3位，然后空位补1，
即原先x的二进制为#####,则y的二进制为#####111   小易的移动，最终可以表达成4x+3操作进行了m次，8x+7操作进行了n次  4*x+3操作进行m次，则x的二进制后面增加2m个1 8*x+7操作进行n次，则x的二进制后面增加了3n个1 小易的移动，
最终可以表达为：x的二进制后面增加了（2m+3n）个1 移动的顺序对其到达没有影响   小易移动次数的分析  初始位置为0，则直接满足，需移动0次 初始位置不为0，则记times = （2m+3n）,m取1到10_0000,n取1到10_0000  所以，times的取值范围为[2,30_0000]。
即：最多30_0000次搜索，就能获得结果。  由于幂次操作数值过大，需要作出变换。参考牛客网用户。
 **/
import java.util.Scanner;

/**
 * Created by Halley on 2017/8/11.
 */
public class Main {
    public static final long LIMIT = 300000;//最多搜索次数
    public static final long N = 1000000007;//求余

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(sol(sc.nextLong()));
        }
    }

    //次数判定方法
    public static long sol(long in){
        //如果初始位置为0，则直接可行，返回0次
        if(in == 0){
            return 0L ;
        }else{//初始位置不为0，则开始搜索
            return search(in);
        }
    }

    //不为0时的搜索
    public static long search(long in){//参数：初始坐标
        long temp = in;
        //遍历，获取最小位移
        for(int i=1;i<=LIMIT;i++){
            //long temp = (in+1)*(long)Math.pow(2,i)-1;//当循环较大时，幂次太高，数字超出范围，报错
            //递推
            temp = (temp * 2 + 1 ) % N;
            if( temp % N == 0 ){
                //i是符合条件的最小偏移，然后对其进行分解
                for(int j =0;j<=(i / 2);j++){//j对应a值
                    if((i - 2*j) % 3 == 0){
                        return j+(i-2*j)/3;
                    }
                }
            }
        }
        //超过最大次数还没匹配，则输出-1
        return -1L;
    }
}