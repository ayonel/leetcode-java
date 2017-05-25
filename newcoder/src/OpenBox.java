import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-05-24 21:55
 * @blog https://ayonel.me
 **/
public class OpenBox {

    //搜索有无和是指定数的组合
    public boolean sum(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        bfs(array, target, 0, new ArrayList<>(), res);
        return res.size() != 0;

    }

    public void bfs(int[] array,int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(path);
            return;
        }
        for (int i = index+1; i < array.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(path);
            list.add(array[i]);
            bfs(array, target-array[i], i, list, res);
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
        OpenBox ob = new OpenBox();

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += array[i];
        }

        //搜索有无和是指定数的组合
        while (m <= maxSum) {
            if (ob.sum(array, m)) {
                System.out.println("Yes");
                return;
            }
            m+=m;
        }
        System.out.println("No");

    }
}



