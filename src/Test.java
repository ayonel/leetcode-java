import java.util.Scanner;

/**
 * test
 *
 * @author ayonel
 * @create 2017-05-23 14:22
 * @blog https://ayonel.me
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }

    }
}
