package classic;

import java.util.HashSet;

/**
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-18 13:15
 * @blog https://ayonel_113_PathSumII.me
 **/
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p = pHead1;
        ListNode q = pHead2;

        if (pHead1 == pHead2)
            return pHead1;
        HashSet<ListNode> set1 = new HashSet<>();
        HashSet<ListNode> set2 = new HashSet<>();
        while (p != null && q != null) {
            if (set1.contains(q)){
                return q;
            }

            if (set2.contains(p)){
                return p;
            }
            set1.add(p);
            set2.add(q);
            p = p.next;
            q = q.next;
        }
        if (q == null) {
            while(p != null) {
                if (set2.contains(p)){
                    return p;
                }
                p = p.next;
            }

        }

        if (p == null) {
            while(q != null) {
                if (set1.contains(q)){
                    return q;
                }
                q = q.next;
            }
        }

        return null;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);

        ListNode node1_1 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node7;

//        node5.next = node6;
//        node6.next = node7;


        ListNode res = new FirstCommonNode().FindFirstCommonNode(node1, node1_1);
        System.out.println(res.val);
    }
}
