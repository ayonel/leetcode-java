package ayonel_92_ReverseLinkedListII;

import ayonel_2_AddTwoNumbers.ListNode;

import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-21 20:30
 * @blog https://ayonel.me
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 **/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        ListNode  pre = dummyHead;
        ListNode p = head;
        ListNode start = null;
        ListNode preStart = null;
        ListNode tmp = null;
        int i = 1;
        while (i <= n) {
            if (i < m) { //还没到m，一直走
                pre = p;
                p = p.next;
            } else if(i == m) { //开始逆转了
                preStart = pre;
                start = p;
                pre = p;
                p = p.next;
            } else if(i == n) { //走到n，逆转，接收尾
                tmp = p.next;
                p.next = pre;
                preStart.next = p;
                start.next = tmp;
            } else { //m到n之间，逆转
                tmp = p.next;
                p.next = pre;
                pre = p;
                p = tmp;
            }
            i++;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode res = new Solution().reverseBetween(node1, 1,2);
        while(res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
