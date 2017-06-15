package ayonel_61_RotateList;

import ayonel_2_AddTwoNumbers.ListNode;

/**
 * Rotate List
 *
 * @author ayonel
 * @create 2017-06-15 15:02
 * @blog https://ayonel.me
 * 解题思路：找到倒数第k个节点，然后断成两部分，把第二部分接到第一部分头上,需要注意k有可能大于链表长度，需要求模
 * 还要考虑k正好等于链表长度，以及链表为空的特殊情况
 *
 * 在已经知道链表长度的情况下，求倒数第n个元素，没必要用快慢指针，直接计数就ok
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0||head==null)
            return head;
        ListNode fast = head, slow = head, prevSlow = head, prevFast = head;
        //计算有多少个节点
        ListNode p = head;
        int nodeCount = 0;
        while (p != null) {
            nodeCount++;
            p = p.next;
        }
        k  = k % nodeCount;
        if (k == 0)
            return head;
        int count = 0;
        while(fast != null && slow != null) {
            prevSlow = slow;
            prevFast = fast;
            fast = fast.next;
            if (count >= k) {
               slow = slow.next;
            }
            count++;
        }



        prevSlow.next = null;
        prevFast.next = head;
        return slow;
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
        ListNode newNode = new Solution().rotateRight(node1, 1);
        while (newNode!=null){
            System.out.print(newNode.val+" ");
            newNode = newNode.next;
        }

    }

}