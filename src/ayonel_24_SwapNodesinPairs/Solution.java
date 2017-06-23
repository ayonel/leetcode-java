package ayonel_24_SwapNodesinPairs;

import ayonel_2_AddTwoNumbers.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-11 21:41
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode last = head.next;
        ListNode tmp = last.next;

        last.next = pre;
        pre.next =  swapPairs(tmp);
        return last;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = new Solution().swapPairs(node1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }



}
