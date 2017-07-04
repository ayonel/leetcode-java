package ayonel_206_ReverseLinkedList;

import ayonel_141_LinkedListCycle.ListNode;

/**
 * @author ayonel
 * @create 2017-07-04 18:48
 * @blog https://ayonel.me
 * 命名导致好乱
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
    /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode node, ListNode pre) {
        if (node == null)
            return pre;
        ListNode next = node.next;
        node.next = pre;
        return reverseListInt(next, node);
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        new Solution().reverseList(node1);


    }

}
