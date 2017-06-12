package ayonel_21_MergeTwoSortedLists;

import java.util.List;

/**
 * Merge Two Sorted Lists
 *
 * @author ayonel
 * @create 2017-06-08 15:58
 * @blog https://ayonel.me
 *
 * 解题思路：复杂度为O(m+n)
 * 先从较小的那条链上扫，如果扫到比另一条链大的，需要从另外一条链上扫，i,j之间有个巧妙的替换。
 * 还可以用递归，见2
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if(l1.val <= l2.val)
            return solve(l1, l2);
        else
            return solve(l2, l1);

    }

    public ListNode solve(ListNode l1, ListNode l2) {
        ListNode j = l2;
        ListNode head = l1;
        ListNode i = l1;

        while(i.next != null && j!= null) {
            if(i.next.val <= j.val){
                i = i.next;
            } else {
                ListNode tmp = i.next;
                i.next = j;
                i = i.next;
                j = tmp;
            }
        }

        i.next = j;
//        while(head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node2_2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next =node5;

        node2_2.next = node3;
        node3.next = node4;

        new Solution().mergeTwoLists(node1, node2_2);

    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

}
