package ayonel_71_SimplifyPath;

import java.util.*;

/**
 * 71. Simplify Path
 *
 * @author ayonel
 * @create 2017-06-15 21:20
 * @blog https://ayonel.me
 * 解题思路：想复杂了，下面有标准答案
 **/
public class Solution {
    public String simplifyPath(String path) {
        //先过滤"//"这种情况
        StringBuilder str = new StringBuilder();
        int len = path.length();
        if (len <= 1)
            return path;
        for (int i = 0; i < len-1; i++) {
            if (path.charAt(i) == '/' && path.charAt(i+1) == '/'){
                continue;
            } else
                str.append(path.charAt(i));
        }
        str.append(path.charAt(len-1));
        int realLen = str.length();
//        int cnt = realLen-1;
//        while(str.charAt(cnt) == '.') {
//            str.deleteCharAt(cnt);
//            cnt--;
//        }
//        realLen = str.length();

        StringBuilder res = new StringBuilder("/");
//        if (res.toString() == "/")
//            return "/";

        int i = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (i < realLen) {
            if (str.charAt(i) == '.'){
                if (i+1 < realLen && str.charAt(i+1) == '/'){
                    i+=2;
                    continue;
                }
                if (i+2 < realLen && str.charAt(i+1) == '.' && str.charAt(i+2) == '/'){
                    if (stack.size() > 1)
                        stack.pop();
                    if (stack.size() == 1){
                        res = new StringBuilder("/");
                    } else {
                        if (!stack.isEmpty() && stack.peek() + 1 < res.length())
                            res.replace(stack.peek()+1, res.length(), "");
                    }
                    i += 3;
                } else {
                    i+=3;
                    continue;
                }
            } else if (str.charAt(i) == '/') {
                res.append('/');
                stack.push(res.length()-1);
                i++;
            } else {
                res.append(str.charAt(i));
                i++;
            }

        }
        if (!res.toString().equals("/") && res.charAt(res.length()-1) == '/')
            return res.substring(0, res.length()-1);

        return res.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/..."));
    }

    public String simplifyPathStandard(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }


}
