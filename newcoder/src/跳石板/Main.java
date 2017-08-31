package 跳石板;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-28 22:09
 * @blog https://ayonel.me
 * 广搜
 **/
public class Main {
    public static boolean[] notPrime;
    public static boolean[] visited;
    public static void genPrime(int n){
        notPrime = new boolean[n+1];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (M==N){
            System.out.println("0");
            return;
        }
        visited = new boolean[M+1];
        visited[0] = true;
        visited[1] = true;
        genPrime(M);
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deep = new ArrayDeque<>();
        deque.push(N);
        deep.push(0);
        int node,dep, fac1, fac2;

        while (!deque.isEmpty()){
            node = deque.poll();
            dep = deep.poll();

            if (!notPrime[node]){
                //质数
                continue;
            }
            for (int j = 2; j <= (int)Math.sqrt(node); j++) {

                if (node % j == 0){
                    fac1 =  node+j;
                    fac2 = node+node/j;
                    if (fac1 == M||fac2 == M){
                        System.out.println(dep+1);
                        return;
                    }

                    if (fac1<=M && notPrime[node+j] && !visited[node+j]){
                        deque.offer(fac1);
                        deep.offer(dep+1);
                        visited[fac1] = true;
                    }
                    if (fac1 != fac2 && fac2 <= M && notPrime[fac2] && !visited[fac2]){
                        deque.offer(fac2);
                        deep.offer(dep+1);
                        visited[fac2] = true;
                    }
                }
            }
        }
        System.out.println(-1);

    }


}
