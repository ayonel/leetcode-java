package ayonel_141_LinkedListCycle;


/**
 * @author ayonel
 * @create 2017-06-29 16:05
 * @blog https://ayonel.me
 * 解题思路：
 * 快慢指针,其实slow = head， fast = head.next
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow )
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node2;

        System.out.println(new Solution().hasCycle(node1));
    }

}
