package ayonel_142_LinkedListCycleII;

import ayonel_141_LinkedListCycle.ListNode;

/**
 * @author ayonel
 * @create 2017-06-29 16:20
 * @blog https://ayonel.me
 * 解题思路：看注释，这智商咋想不起来了
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            cycleLength++;
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }
        //没有环，返回null
        if (!hasCycle)
            return null;
        // 从头部，开始，先让fast走cycleLength 步，然后一起往前走，直到fast==slow
        slow = head;
        fast = head;
        int step = 0;
        while(true) {
            step++;
            if (step > cycleLength) {
                if (slow == fast)
                    return slow;
                slow = slow.next;
            }
            fast = fast.next;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node1;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(new Solution().detectCycle(node1).val);
    }

}