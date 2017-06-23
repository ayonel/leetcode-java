package ayonel_149_MaxPointsonaLine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-14 09:59
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：double 有精度温度，例如main函数里的样例就过不了，除非用最简分数表示
 **/

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int length = points.length;
        if (length <= 2)
            return length;
        HashSet<String> indexSet = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        //把不重复的坐标加入
        //构造重复坐标字典
        HashMap<String, HashSet<String>> lineMap = new HashMap<>();

        for (Point p : points) {
            if (!indexSet.contains(p.x+","+p.y)) {
                indexSet.add(p.x+","+p.y);
            }
            if (!map.containsKey(p.x+","+p.y)){
                map.put(p.x+","+p.y, 1);
            } else {
                map.put(p.x+","+p.y, map.get(p.x+","+p.y) + 1);
            }
        }

        String[] pointsWithRepeat = new String[indexSet.size()];

        int k = 0;
        for (String index: indexSet) {
            pointsWithRepeat[k] = index;
            k++;
        }



        for(int i = 0; i <= pointsWithRepeat.length-2; i++) {
            for (int j = i+1; j <= pointsWithRepeat.length-1; j++) {
                String[] bPiece = pointsWithRepeat[j].split(",");
                int b_x = Integer.valueOf(bPiece[0]);
                int b_y = Integer.valueOf(bPiece[1]);

                String[] aPiece = pointsWithRepeat[i].split(",");
                int a_x = Integer.valueOf(aPiece[0]);
                int a_y = Integer.valueOf(aPiece[1]);
                String line = lineFunction(a_x,a_y,b_x,b_y);

                if (lineMap.containsKey(line)){
                    lineMap.get(line).add(""+a_x+","+a_y);
                    lineMap.get(line).add(""+b_x+","+b_y);
                } else {
                    lineMap.put(line, new HashSet<String>());
                    lineMap.get(line).add(""+a_x+","+a_y);
                    lineMap.get(line).add(""+b_x+","+b_y);
                }
            }

        }

        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max)
                max = entry.getValue();
        }

        for (Map.Entry<String, HashSet<String>> entry: lineMap.entrySet()){
            int tmp = 0;
            for(String line : entry.getValue()){
                tmp += map.get(line);
            }
            max = Math.max(max, tmp);
        }

        return max;


    }

    public String lineFunction(int a_x, int a_y, int b_x, int b_y) { //斜截式方程
        if (b_x == a_x) {
            return "max,"+a_x;
        } else {
            double K = (double)(b_y - a_y) / (double)(b_x - a_x);
            double B = (double)a_y - (double)K*a_x;
            System.out.println(K);
            return ""+K+","+B;
        }

    }

    public static void main(String[] args) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(94911151,94911150);
        Point point3 = new Point(94911152,94911151);
//        Point point4 = new Point(1,4);
//        Point point5 = new Point(2,1);
        Point[] points = {point1,point2,point3};


        System.out.println(new Solution().maxPoints(points));
    }
}
