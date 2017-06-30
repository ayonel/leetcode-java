package ayonel_147_InsertionSortList;

import ayonel_141_LinkedListCycle.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-30 09:57
 * @blog https://ayonel.me
 **/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0), p = head, start = head, pNNext, startNext;
        dummyHead.next = head;
        while (p != null && p.next != null) {
            if (p.val > p.next.val) {
                //从头开始找要插入的位置
                start = dummyHead;
                pNNext = p.next.next;
                while (start.next.val < p.next.val){
                    start = start.next;
                }
                startNext = start.next;
                start.next = p.next;
                p.next.next = startNext;
                p.next = pNNext;
                continue;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }




    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node5.next = node1;
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        ListNode sorted = new Solution().insertionSortList(node1);
        while (sorted!=null)
        {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }
    }
}