package ayonel_217_ContainsDuplicate;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dimera on 2017/4/11.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 * 解题思路，构造一个set
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean result = false;
        for (int ele: nums) {

            if (set.contains(ele)) {
                result = true;
                break;
            }
            set.add(ele);
        }
        return result;
    }
}
