package ayonel_17_LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * Letter Combinations of a Phone Number
 *
 * @author ayonel
 * @create 2017-06-08 14:40
 * @blog https://ayonel.me
 * 解题思路：遍历输入字符串，保存遍历到当前位置时的结果，再对每个结果后面一个当前位置对应的char  效率有些低
 *
 * 可以用LinkedList 模拟队列，FIFO，这样就不用额外的空间开销，见2
 *
 **/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        HashMap<Character,List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));

        for(int i = 0; i < digits.length(); i++) {
            char c = digits.charAt((i));
            if(res.size() == 0) {
                for(Character letter : map.get(c)){
                    res.add("" + letter);
                }
            } else {
                List<String> tmpRes = new ArrayList<>();
                for(Character letter : map.get(c)) {
                    for(String last: res) {
                        tmpRes.add(last + letter);
                    }
                }

                res.clear();
                res.addAll(tmpRes);

            }

        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}
