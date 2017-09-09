import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public int bulbSwitch(int n) {
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if (i*i<=n)
                ans++;
            else
                break;
        }
        System.out.println(ans);
        return ans;
    }


    public static void main(String[] args) {
        new Main().bulbSwitch(99999999);
    }
}