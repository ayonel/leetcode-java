import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i)))
            map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i))+1);

        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1)
                set.add(entry.getKey());
        }
        int i = 0;
        for(; i < str.length(); i++) {
            if(set.contains(str.charAt(i)))
                break;
        }

        return i;
    }
}