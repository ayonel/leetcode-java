package 有趣的数字;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ayonel
 * @create 2017-08-26 21:02
 * @blog https://ayonel.me
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            String input = sc.nextLine();

            String[] array = input.trim().split("\\s+");

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            Arrays.sort(nums);
            int min = nums[0], minCount = 1;
            int max = nums[n-1], maxCount = 1;

            if (min == max){
                System.out.println(""+(n*(n-1)/2) +" "+(n*(n-1)/2));
            } else {
                boolean hasSame = false;

                for (int i = 1; i < n; i++){
                    if (nums[i] == min){
                        minCount++;
                        hasSame = true;
                    }else{
                        break;
                    }
                }
                for (int i = n-2; i >= 0; i--){
                    if (nums[i] == max){
                        maxCount++;
                        hasSame = true;
                    }else{
                        break;
                    }
                }

                int continuous = 0;
                int cnt = 1;
                if (hasSame){
                    for (int i = 1; i < n; i++) {
                        if (nums[i] == nums[i-1]){
                            cnt++;
                        }  else {
                            if (cnt>=2){
                                continuous+=(cnt*(cnt-1)/2);
                            }
                            cnt=1;
                        }
                    }
                    if (cnt>=2){
                        continuous+=(cnt*(cnt-1)/2);
                    }
                    System.out.println(continuous+" "+(maxCount*minCount));
                } else {
                    //没有重复

                    int minGap = Integer.MAX_VALUE;
                    for (int i = 1; i < n; i++) {
                        minGap = Math.min(minGap, nums[i]-nums[i-1]);
                    }
                    int minGapCount = 0;
                    for (int i = 1; i < n; i++) {
                        if (nums[i] - nums[i-1] == minGap){
                            minGapCount++;
                        }
                    }
                    System.out.println(minGapCount+" "+(maxCount*minCount));
                }

            }

        }
    }
}
