package ayonel_68_TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-15 16:45
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int curLengthOfWord = 0;
        List<String> str = new ArrayList<String>();
        if (words.length == 0)
            return res;
        for (int i = 0; i < words.length - 1; i++) {
            curLengthOfWord += words[i].length();
            str.add(words[i]);
            if (curLengthOfWord + words[i+1].length() + str.size() > maxWidth){
                StringBuilder curStr = new StringBuilder(str.get(0));
                str.remove(0);
                int spaceNum = maxWidth - curLengthOfWord;
                int k = 0;
                if (spaceNum == 0){
                    res.add(curStr.toString());
                    curLengthOfWord = 0;
                    str = new ArrayList<>();
                    continue;
                }
                if (str.size() == 0) {
                    while(k < spaceNum) {
                        curStr.append(' ');
                        k++;
                    }
                    res.add(curStr.toString());
                    curLengthOfWord = 0;
                    str = new ArrayList<>();
                    continue;
                }

                ArrayList<Integer> spaceNumList = new ArrayList<>();
                for (int j = 0; j < str.size(); j++) {
                    spaceNumList.add(0);
                }
                while(k < spaceNum) {
                    spaceNumList.set(k%str.size(), spaceNumList.get(k%str.size())+1);
                    k++;
                }

                for (int j = 0; j < str.size(); j++) {
                    for (int l = 0; l < spaceNumList.get(j); l++) {
                        curStr.append(" ");
                    }
                    curStr.append(str.get(j));
                }
                res.add(curStr.toString());
                curLengthOfWord = 0;
                str = new ArrayList<>();
            }

        }
        str.add(words[words.length-1]);
        StringBuilder curStr = new StringBuilder(str.get(0));
        str.remove(0);
        if (curStr.length() == maxWidth) {
            res.add(curStr.toString());
            return res;
        }

        for (String lastLineEle: str) {
            if (curStr.length()+lastLineEle.length() + 1 <= maxWidth)
                curStr.append(" "+lastLineEle);
        }
        for (int i = curStr.length(); i < maxWidth; i++) {
            curStr.append(' ');
        }

        res.add(curStr.toString());

        return res;

    }

    public static void main(String[] args) {
        String[] words = {"world","owes","you","a","living;","the","world"};
//        String[] words = {""};
        System.out.println(new Solution().fullJustify(words, 30));
    }
}
