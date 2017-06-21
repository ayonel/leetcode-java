package ayonel_86_PartitionList;

import ayonel_2_AddTwoNumbers.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.  You should preserve the original relative order of the nodes in each of the two partitions.  For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 * @author ayonel
 * @create 2017-06-21 13:24
 * @blog https://ayonel.me
 * 解题思路：用了很多额外指针，不断变向，太乱了，看标准解法
 **/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        ListNode p = head;
        ListNode preFirstLarge = dummyHead;
        ListNode preP = dummyHead;

        while(p != null) {
            if (p.val < x) {
                preFirstLarge = p;
                p = p.next;
            } else {
                break;
            }

        }
        if (p != null){
            preP = p;
            p = p.next;
        }

        else{
            return head;
        }

        while (p != null) {
            if (p.val >= x) {
                preP = p;
//                preFirstLarge = p;
                p = p.next;

            } else {
                tmp1 = preFirstLarge.next;
                tmp2 = p.next;
                preFirstLarge.next = p;
                p.next = tmp1;
                preFirstLarge = p;
                preP.next = tmp2;
                p = tmp2;
//                preP = tmp1;


            }
        }

        return dummyHead.next;
    }

    public ListNode partitionStandard(ListNode head, int x) {
        ListNode p1 = new ListNode(0); //存大于等于x
        ListNode p2 = new ListNode(0); //存小于x
        ListNode p1_back = p1;
        ListNode p2_back = p2;
        while (head != null) {
            if (head.val < x) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
            head = head.next;
        }
        p1.next = null;
        p2.next = p1_back.next;
        return p2_back.next;


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode head = new Solution().partition(node1, 3);
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
