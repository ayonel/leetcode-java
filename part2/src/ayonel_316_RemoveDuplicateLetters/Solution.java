package ayonel_316_RemoveDuplicateLetters;


import java.util.*;

/**
 * @author ayonel
 * @create 2017-09-02 22:21
 * @blog https://ayonel.me
 * 快炸了 不写了
 **/
class Solution {
    static char[] array;
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();

        array = s.toCharArray();
        int n = array.length;
        for (char c : array) {
            set.add(c);
        }

        ArrayList<String> longestAscSq = new ArrayList<>();
        int[] dp = new int[n];
        dp[0] = 1;
        ArrayList<ArrayList<Integer>>[] DP = new ArrayList[n];
        DP[0] = new ArrayList<>();
        DP[0].add(new ArrayList<>());
        DP[0].get(0).add(0);

        for (int i = 1; i < n; i++) {
            DP[i] = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if(array[j]< array[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                else {
                    dp[i] = Math.max(1, dp[i]);
                }

            }
            if (dp[i] == 1){
                DP[i].add(new ArrayList<>());
                DP[i].get(0).add(i);
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] == dp[i]-1 && array[j] < array[i]){
                    for(ArrayList<Integer> last: DP[j]){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.addAll(last);
                        list.add(i);
                        DP[i].add(list);
                    }
                }
            }
        }


        int maxAscLen = 1;
        for (int i = 0; i < n; i++) {
            maxAscLen = Math.max(dp[i], maxAscLen);
        }

        ArrayList<ArrayList> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (DP[i].get(0).size() == maxAscLen){
                list.addAll(DP[i]);
            }
        }
        System.out.println(list);

        list.sort(new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                StringBuilder s1 = new StringBuilder();
                for (int i = 0; i < o1.size(); i++) {
                    s1.append(array[(int)o1.get(i)]);
                }
                StringBuilder s2 = new StringBuilder();
                for (int i = 0; i < o2.size(); i++) {
                    s2.append(array[(int)o2.get(i)]);
                }
                return s1.toString().compareTo(s2.toString());
            }
        });

        String res = "";
        for (int i = 0; i < maxAscLen; i++) {
            res += array[(int)list.get(0).get(i)];
        }

        System.out.println(res);
        HashSet<Character> have = new HashSet<>();
        for(char c : res.toCharArray()){
            have.add(c);
        }
        set.removeAll(have);

        System.out.println(set);

        ArrayList<Character> part1 = new ArrayList<>();

        for (int i = 0; i < (int)list.get(0).get(0); i++) {
            if (set.contains(array[i])){
                part1.add(array[i]);
            }
        }

        return "";

    }


    public static void main(String[] args) {
        new Solution().removeDuplicateLetters("cbacdcbc");
    }
}
