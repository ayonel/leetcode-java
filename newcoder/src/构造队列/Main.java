package 构造队列;

/**
 * @author ayonel
 * @create 2017-08-29 13:21
 * @blog https://ayonel.me
 **/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++){
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < T; i++) {
            Deque<Integer> Q = new ArrayDeque<>(nums[i]);

            for (int j = nums[i]; j >= 1; j--) {
                Q.addFirst(j);
                int x = Q.removeLast();
                Q.addFirst(x);
            }
            while (Q.size()>=2){
                System.out.print(Q.poll()+" ");
            }
            System.out.println(Q.poll());

        }

    }

}
