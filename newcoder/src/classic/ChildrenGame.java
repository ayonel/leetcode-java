package classic;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-18 20:20
 * @blog https://ayonel_113_PathSumII.me
 **/


import java.util.ArrayList;

public class ChildrenGame {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0)
            return -1;

        ArrayList<Integer> children = new ArrayList<Integer>();
        for(int i = 0; i < n ; i++) {
            children.add(i);
        }

        int i = 0;
        int gap = 0;
        while(children.size() > 1) {
            if (gap+1 == m) {
                children.remove(i);
                gap = 0;
                if (i > children.size() - 1)
                    i = 0;
            } else {
                gap++;
                if (i >= children.size() - 1)
                    i = 0;
                else
                    i++;
            }
        }
        return children.get(0);
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for ( int i= 0 ; i<length; i++) {
            int index = numbers[i];
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;

    }



    public static void main(String[] args) {
        int[] numbers = {2,1,3,1,4};
        int[] duplication = new int[1];
        System.out.println(new ChildrenGame().duplicate(numbers, 5, duplication));
    }
}