package ayonel_541_ReverseStringII;


/**
 * @author ayonel
 * @create 2017-07-22 21:29
 * @blog https://ayonel.me
 **/
public class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int n = s.length(), last = 0;
        if (k >= n) {
            reverse(array, 0, n-1);
            return String.copyValueOf(array);
        }

        int count = 1;
        for(int i = 0; i < array.length; i++) {
            if(count == 1) last = i;
            if(count == k) {
                reverse(array, i-k+1, i);
                count = -k+1;
            } else{
                count++;
            }
        }
        count--;
        if (count> 0 && count<k) reverse(array,last, n-1);

        return String.copyValueOf(array);

    }

    public void reverse(char[] array, int s, int e) {
        while(s<e){
            char tmp = array[s];
            array[s] = array[e];
            array[e] = tmp;
            s++;
            e--;
        }

    }

    public static void main(String[] args) {
//        new Solution().reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",
//                39);
        System.out.println(new Solution().reverseStr("abcdefg", 6));
    }
}
