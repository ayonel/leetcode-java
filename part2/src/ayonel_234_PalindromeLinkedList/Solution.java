package ayonel_234_PalindromeLinkedList;

import ayonel_141_LinkedListCycle.ListNode;
import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-10 17:56
 * @blog https://ayonel.me
 * 找到重点，逆转后半部分
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head, slow = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            //链表长度为奇数
            slow = slow.next;//slow 是后半部分链表的头
        }

        ListNode second = reverse(slow);
        while (second != null) {
            if (second.val != head.val)
                return false;
            second = second.next;
            head = head.next;
        }

        return true;

    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode pre = null, p = node,next;
        while (p.next != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        p.next = pre;
        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        System.out.println(new Solution().isPalindrome(node1));
        System.out.println();
    }
}
