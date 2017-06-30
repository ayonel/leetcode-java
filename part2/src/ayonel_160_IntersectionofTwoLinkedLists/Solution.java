package ayonel_160_IntersectionofTwoLinkedLists;

import ayonel_141_LinkedListCycle.ListNode;

/**
 * @author ayonel
 * @create 2017-06-30 20:38
 * @blog https://ayonel.me
 * 先让两个链表从头开始往后走，可以计算出两个链表的长度，并且能知道两个链表的最后一个节点是否相同（相同，表明有交点，否则，无交点）
 * 然后让长的链表先走（两条链长度差）步，则第一个两链相同处就是所求点
 **/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int lenA = 0, lenB = 0;
        while (A != null && A.next != null) {
            lenA++;
            A = A.next;
        }
        while (B != null && B.next != null) {
            lenB++;
            B = B.next;
        }

        if (A != B || A==null){//最后一个节点不同，不相交
            return null;
        }

        int gap = Math.abs(lenA-lenB);
        if (lenA >= lenB) { //A长
            return getFirstMeet(headA, headB, gap);
        } else {
            return getFirstMeet(headB, headA, gap);
        }

    }

    public ListNode getFirstMeet(ListNode headA, ListNode headB, int gap) {
        //A 长
        int count = 0;
        while (headA != headB) {
            if (count >= gap) {
                headB = headB.next;
            }
            count++;
            headA = headA.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node7.next = node6;
        System.out.println(new Solution().getIntersectionNode(node1, node7).val);

    }
}
