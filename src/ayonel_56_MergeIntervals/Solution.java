package ayonel_56_MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 *
 * @author ayonel
 * @create 2017-05-24 15:06
 * @blog https://ayonel.me
 *
 * 解题思路：先对intervals排序，然后扫描，如果当前元素的start大于当前记录的最大的end，则把原先记录的start,end填入结果链表
 * 否则，说明重叠了，更新当前记录的最大end为该元素的end,知道扫描完毕。
 * 最后还需要把最终的start，end 填入结果链表，否则会漏掉最后一个。
 **/
public class Solution {
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
        list.add(new Interval(8,16));
        list.add(new Interval(15,18));
        list.add(new Interval(2,6));

        Solution s = new Solution();
        s.merge(list);
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}