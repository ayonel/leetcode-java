
import java.util.*;


public class Main1 {
    /* Returns true if y is a power of x */
    public static boolean isPower (int x, int y)
    {
        // The only power of 1 is 1 itself
        if (x == 1)
            return (y == 1);

        // Repeatedly compute power of x
        int pow = 1;
        while(pow < y)
            pow = pow * x;

        // Check if power of x becomes y
        return (pow == y);
    }
    public static void main(String[] args) {

        int sumRes = 0;
        Scanner scanner = new Scanner(System.in);
        int inNum = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int sumAB[][] = new int[inNum + 1][inNum + 1];
        for (int i=1;i<=inNum;i++) {
            for(int j=1;j<=inNum;j++) {
                sumAB[i][j] = (int) Math.pow(i,j);
                for(int k=1;k<=inNum;k++) {
                    if (isPower(k, sumAB[i][j])) {
                        sumRes++;
                        sumRes=sumRes%1000000007;
                    }
                }

            }
        }


        System.out.println(sumRes);

    }


}

