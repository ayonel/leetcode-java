import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-05-25 12:44
 * @blog https://ayonel.me
 **/
public class InversionsDP {

    private int inversion(int n, int k) {
        int[][] matrix = new int[1001][1001];
        for (int i = 1; i <= n; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 2; i<=1000; i++) {
            for(int j = 1; j <= 1000 && j <= i * (i - 1) / 2 ; j++) {
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
                if (j >= i)
                    matrix[i][j] -= matrix[i-1][j-i];
            }
        }

        return matrix[n][k];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        InversionsDP i = new InversionsDP();
        System.out.println(i.inversion(n,k));
    }
}
