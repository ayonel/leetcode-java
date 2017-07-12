package ayonel_299_BullsandCows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ayonel
 * @create 2017-07-12 15:21
 * @blog https://ayonel.me
 * 解题思路：现在一边确定bull的位置以及个数，把这些bull的位置存入一个set，以后找cow的时候直接忽略这些位置
 * 然后再分别对guess以及secret扫，在非bull的位置，对每个数字计数。
 * 求每个数字在secret中的计数和guess中计数的较小值，所有这些较小值的和就是cow
 **/
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        HashSet<Integer> bullSet = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                bullSet.add(i);
            }
        }
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (!bullSet.contains(i)) {
                if (secretMap.containsKey(secret.charAt(i))) {
                    secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i))+1);
                } else {
                    secretMap.put(secret.charAt(i), 1);
                }

                if (guessMap.containsKey(guess.charAt(i))) {
                    guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i))+1);
                } else {
                    guessMap.put(guess.charAt(i), 1);
                }
            }
        }
        int cow = 0;
        for (Map.Entry<Character, Integer> entry : secretMap.entrySet()) {
            char c = entry.getKey();
            if (guessMap.containsKey(c)){
                cow += Math.min(entry.getValue(), guessMap.get(c));
            }
        }

        return bull+"A"+cow+"B";

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}
