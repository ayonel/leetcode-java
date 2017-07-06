package ayonel_214_ShortestPalindrome;

/**
 * @author ayonel
 * @create 2017-07-05 16:04
 * @blog https://ayonel.me
 * 解题思路：最最后一位开始往前找，找到第一个（也是最长的一个）能与之前的子串构成回文串的位置，这时的这个回文子串相当于
 * 是以s[0]开头的最长的回文子串，然后把这个位置之后的子串反转拼接在输入s之前
 *
 * 最长回文子串的解法可以使用s+'#'+reverse(s)，然后用KMP求next数组的算法，得出next值，
 * next数组的最后一位，代表原串中最长的回文子串长度（从下标0开始）
 * https://leetcode.com/problems/shortest-palindrome/#/solutions
 **/
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        char[] array = s.toCharArray();
        int i = array.length-1, j=i;
        while (i >= 0){
            if (array[i] == array[0] && isPal(array, 0, i))
                break;
            i--;
        }
        StringBuilder pre = new StringBuilder();
        while (j > i) {
            pre.append(array[j]);
            j--;
        }

        return pre+s;
    }

    private boolean isPal(char[] array, int lo, int hi) {
        int mid = (lo+hi)/2;
        int i,j;

        if ((hi-lo)% 2 == 0) {
            //有奇数个
            i = mid-1;
            j = mid+1;
        } else {
            i = mid;
            j = mid+1;
        }
        while (i >= lo) {
            if (array[i] != array[j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    public int[] getNext(String b)
    {
        int len=b.length();
        int j=0;

        int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0]=next[1]=0;

        for(int i=1;i<len;i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while(j>0&&b.charAt(i)!=b.charAt(j))
                j=next[j];

            if(b.charAt(i)==b.charAt(j))
                j++;
            next[i+1]=j;
        }

        return next;
    }

    public static void main(String[] args) {
        int[] a = new Solution().getNext("catacb#bcatac");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}

