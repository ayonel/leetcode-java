package classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * @author ayonel
 * @blog https://ayonel.me
 **/
public class OpenBoxBig {

    //搜索有无和是指定数的组合
    public boolean sum(int[] array, BigInteger target) {
        if (array.length < 1)
            return false;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        bfs(array, target, 0, new ArrayList<Integer>(), res);
        return res.size() != 0;

    }

    public void bfs(int[] array,BigInteger target, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        target = target.subtract(new BigInteger(array[index]+""));
        if (res.size() != 0)
            return;
        if (target.compareTo(new BigInteger("0")) == -1)
            return;
        if (target.compareTo(new BigInteger("0")) == 0) {
            res.add(path);
            return;
        }
        for (int i = index+1; i < array.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(path);
            list.add(array[i]);
            bfs(array, target.subtract(new BigInteger(array[i]+"")), i, list, res);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        OpenBoxBig ob = new OpenBoxBig();

        BigInteger maxSum = new BigInteger(0+"");
        for (int i = 0; i < n; i++) {
            maxSum = maxSum.add(new BigInteger(array[i]+"")) ;
        }


        BigInteger bigM = new BigInteger(m+"");

        //搜索有无和是指定数的组合
        BigInteger tmpM = new BigInteger(m+"");
        while (tmpM.compareTo(maxSum) == -1) {
            if (ob.sum(array, tmpM)) {
                System.out.println("Yes");
                return;
            }
            tmpM = tmpM.add(bigM);
        }
        System.out.println("No");
    }
}



