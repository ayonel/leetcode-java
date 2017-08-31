package 地下面额;
import java.util.*;

/**
 * @author ayonel
 * @create 2017-08-29 21:20
 * @blog https://ayonel.me
 * 广搜
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int P = sc.nextInt();

        boolean[][] visit = new boolean[n][m];
        int[][][] last = new int[n][m][2];

        int[][] mat = new int[n][m];
        int[][] health = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
                last[i][j][0] = -1;
                last[i][j][1] = -1;
                health[i][j] = -1;
            }
        }

        Deque<Integer> X = new ArrayDeque<>();
        Deque<Integer> Y = new ArrayDeque<>();

        X.push(0);
        Y.push(0);
        visit[0][0] = true;
        health[0][0] = P;
        int x=0,y=0;

        while (X.size()>0){
            x = X.removeFirst();
            y = Y.removeFirst();
            if ((x != 0 || y != m-1) && health[x][y] <= 0){
                continue;
            }
            if (x == 0 && y == m-1){
                break;
            }
            //右
            if (y < m-1 && mat[x][y+1] == 1 && !visit[x][y+1] && health[x][y] >= 1){
                X.addLast(x);
                Y.addLast(y+1);
                visit[x][y+1] = true;
                last[x][y+1][0] = x;
                last[x][y+1][1] = y;
                health[x][y+1] = health[x][y]-1;
            }
            //上
            if (x > 0 && mat[x-1][y] == 1 && !visit[x-1][y] && health[x][y] >= 3){
                X.addLast(x-1);
                Y.addLast(y);
                visit[x-1][y] = true;
                last[x-1][y][0] = x;
                last[x-1][y][1] = y;
                health[x-1][y] = health[x][y]-3;
            }
            //下
            if (x < n-1 && mat[x+1][y] == 1 && !visit[x+1][y]){
                X.addLast(x+1);
                Y.addLast(y);
                visit[x+1][y] = true;
                last[x+1][y][0] = x;
                last[x+1][y][1] = y;
                health[x+1][y] = health[x][y];
            }
            //左
            if (y > 0 && mat[x][y-1] == 1 && !visit[x][y-1] && health[x][y] >= 1){
                X.addLast(x);
                Y.addLast(y-1);
                visit[x][y-1] = true;
                last[x][y-1][0] = x;
                last[x][y-1][1] = y;
                health[x][y-1] = health[x][y]-1;

            }

        }

        if (x != 0 || y != m-1){
            System.out.println("Can not escape!");
            return;
        } else if (health[0][m-1] < 0){
            System.out.println("Can not escape!");
            return;
        }

        Stack<String> stack = new Stack<>();
        stack.push("["+x+","+y+"]");
        int tmpX, tmpY;
        while (x != 0 || y != 0){
            tmpX = last[x][y][0];
            tmpY =  last[x][y][1];
            x = tmpX;
            y = tmpY;
            stack.push("["+x+","+y+"]");
        }

        while (stack.size() > 1){
            System.out.print(stack.pop()+",");
        }
        System.out.print(stack.pop());

    }
}
