package ayonel_57_InsertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Insert Interval
 *
 * @author ayonel
 * @create 2017-05-24 15:41
 * @blog https://ayonel.me
 * 解题思路，利用56中的merge函数，将newInterval插入后merge即可
 **/
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }


    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<>();
        // 先排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start)
                    return 1;
                else if (o1.start == o2.start)
                    return 0;
                else
                    return -1;
            }
        });
        // 如果list中没有元素
        if (intervals.size() == 0)
            return res;

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        res.add(new Interval(start, end));

        return res;

    }


    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(6,9));
//        list.add(new Interval(15,18));
//        list.add(new Interval(2,6));

        Solution s = new Solution();
        List<Interval> l = s.insert(list, new Interval(2,5));
        for (Interval i: l) {
            System.out.println(i.start + "," + i.end);
        }
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}