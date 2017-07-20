package ayonel_401_BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-20 12:55
 * @blog https://ayonel.me
 * 解题思路：把num分成2部分，一部分表示小时，一部分表示分钟数，写的比较冗长，标准答案太伤人了。。
 *
 **/


public class Solution {
    public List<String> readBinaryWatchStandard(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

    private static int hourNum = 4;
    private static int minuteNum = 6;
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= num; i++) {
            List<Integer> hourRes = new ArrayList<>();
            findHour(i, hourRes);
            List<Integer> minuteRes = new ArrayList<>();
            findMinute(num-i, minuteRes);
            for(int hour: hourRes) {
                for(int minute: minuteRes){
                    res.add(construct(hour, minute));
                }
            }
        }
        return res;
    }

    private String construct(int hour, int minute) {
        String str = String.valueOf(hour) +":";
        if (minute < 10) {
            str += "0"+minute;
        } else {
            str += minute;
        }
        return str;
    }

    //寻找小时：
    void findHour(int num, List<Integer> res) {
        if (num == 0) {
            res.add(0);
            return;
        }
        for(int j = 0; j <= hourNum - num; j++) {
            findHour(num, j, res, 0);
        }
    }

    void findHour(int num, int index, List<Integer> res, int cur) {
        cur += pow2(index);
        num--;
        if (cur > 11)
            return;
        if (num == 0) {
            res.add(cur);
            return;
        }
        for(int i = index+1; i < hourNum ; i++){
            findHour(num, i, res, cur);
        }
    }
    //寻找分钟：
    void findMinute(int num, List<Integer> res) {
        if (num == 0) {
            res.add(0);
            return;
        }
        for(int j = 0; j <= minuteNum - num; j++) {
            findMinute(num, j, res, 0);
        }
    }
    void findMinute(int num, int index, List<Integer> res, int cur) {
        cur += pow2(index);
        num--;
        if (cur > 59)
            return;
        if (num == 0) {
            res.add(cur);
            return;
        }
        for(int i = index+1; i < minuteNum ; i++){
            findMinute(num, i, res, cur);
        }
    }

    int pow2(int x){
        return (int)Math.pow(2, x);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        System.out.println(new Solution().readBinaryWatch(1));
    }



}
