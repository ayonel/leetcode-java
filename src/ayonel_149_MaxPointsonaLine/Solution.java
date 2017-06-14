package ayonel_149_MaxPointsonaLine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * @author ayonel
 * @create 2017-06-14 09:59
 * @blog https://ayonel.me
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
        HashMap<String, HashSet<Point>> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i <= points.length-2; i++) {
            for (int j = i+1; j <= points.length-1; j++) {
                String line = lineFunction(points[i], points[j]);
                if (map.containsKey(line)){
                    map.get(line).add(points[i]);
                    map.get(line).add(points[j]);
                } else {
                    map.put(line, new HashSet<Point>());
                    map.get(line).add(points[i]);
                    map.get(line).add(points[j]);
                }
            }
        }

        for (Map.Entry<String, HashSet<Point>> entry: map.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
            if (entry.getValue().size() > max)
                max = entry.getValue().size();
        }
        return max;

    }

    public String lineFunction(Point a, Point b) { //斜截式方程

        if (b.x == a.x) {
            return "max,"+a.x;
        } else {
            int K =(b.y - a.y) / (b.x - a.x);
            int B = a.y - K*a.x;
            return ""+K+","+B;
        }

    }

    public static void main(String[] args) {
        Point point1 = new Point(3,10);
        Point point2 = new Point(0,2);
        Point point3 = new Point(3,10);
        Point point4 = new Point(0,2);
//        Point point5 = new Point(2,1);
        Point[] points = {point1,point2,point3,point4};


        System.out.println(new Solution().maxPoints(points));
    }
}
