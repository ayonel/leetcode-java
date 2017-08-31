package 回文序列;
import java.util.*;

/**
 * @author ayonel
 * @create 2017-08-29 11:11
 * @blog https://ayonel.me
 * 我的解法是回溯，但内存超了，只能过60
 * 应该用首尾指针递归，https://www.nowcoder.com/questionTerminal/0147cbd790724bc9ae0b779aaf7c5b50
 **/
public class Main {

    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        if (isParlin(list)) {
            System.out.println(0);
        } else{
            solve(list, 0, 0);
            System.out.println(MIN);
        }

    }


    public static void solve(ArrayList<Integer> list, int curStep, int index){
        int size = list.size();
        if (size == 1){
            MIN = Math.min(MIN, curStep);
            return;
        }

        if (isParlin(list)){
            MIN = Math.min(MIN, curStep);
            return;
        }
        for (int i = 0; i < size-1; i++) {
            int fir = list.remove(i);
            int sec = list.remove(i);
            list.add(i, fir+sec);
            solve(list, curStep+1, 0);
            list.remove(i);
            list.add(i,sec);
            list.add(i,fir);
        }
    }


    public static boolean isParlin(ArrayList<Integer> list){
        int i = 0, j = list.size()-1;
        while (i < j) {
            if (list.get(i++) != list.get(j--)){
                return false;
            }
        }
        return true;
    }






}
