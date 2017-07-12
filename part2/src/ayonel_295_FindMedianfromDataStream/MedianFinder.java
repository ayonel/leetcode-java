package ayonel_295_FindMedianfromDataStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-12 11:09
 * @blog https://ayonel.me
 * 解题思路：需要把数组维护成有序的，插入的时候二分
 * 也可以用两个优先队列，需要长度相同，各存一半
 **/
public class MedianFinder {
    /** initialize your data structure here. */
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int size = list.size();
        if (size == 0) list.add(num);
        else{
            int lo = 0, hi = size-1, mid;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (list.get(mid) == num) {
                    list.add(mid, num);
                    return;
                } else if(list.get(mid) < num) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
            list.add(lo, num);
        }
    }

    public double findMedian() {
        int size = list.size();
        if ((size & 1) == 1) {  //奇数
            return (double)list.get(size>>1);
        } else {
            return (list.get((size-1)/2) + list.get(size/2))/ (double)2;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
