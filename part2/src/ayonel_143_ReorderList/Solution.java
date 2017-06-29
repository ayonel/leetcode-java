package ayonel_143_ReorderList;

import ayonel_141_LinkedListCycle.ListNode;

/**
 * @author ayonel
 * @create 2017-06-29 17:27
 * @blog https://ayonel.me
 * 解题思路：先把链表平分成两部分，最后拼接
 **/
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        //反转head2
        ListNode pre = head2;
        fast = head2.next;

        while (fast != null) {
            slow = fast.next; //重复利用slow,相当于tmp
            fast.next = pre;
            pre = fast;
            fast = slow;
        }
        head2.next = null;
        head2 = pre;
        //现在head是1--2--3， head2是6--5--4
        //重复利用fast  slow, 如果原来是奇数个节点，则head链要少一个,
        slow = head;
        fast = head2;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (slow != null) {
            tmp1 = slow.next;
            tmp2 = fast.next;
            slow.next = fast;
            //处理原来是奇数个节点，
            if (tmp1!= null)
                fast.next = tmp1;
            slow = tmp1;
            fast = tmp2;
        }

        while (head!=null) {
           System.out.println(head.val);
           head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        new Solution().reorderList(node1);
    }
}
