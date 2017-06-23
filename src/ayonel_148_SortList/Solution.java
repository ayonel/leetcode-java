package ayonel_148_SortList;

import ayonel_2_AddTwoNumbers.ListNode;


/**
 * 148. Sort List
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-14 14:19
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：归并排序
 **/
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }



    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node3.next = node2;
        node2.next = node1;

//        node2.next = node4;
//        node4.next = node5;
        ListNode res =  new Solution().sortList(node3);

        while (res != null) {

            System.out.print(res.val + " ");
            res = res.next;
        }

    }



}
