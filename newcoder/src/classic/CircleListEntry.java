package classic;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * @author ayonel
 * @create 2017-06-19 10:15
 * @blog https://ayonel.me
 * 解题思路：
 * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
来源：牛客网

第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。

第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x;
n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2;
此时p1指向环的入口。

 **/
public class CircleListEntry {

    ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;

        ListNode p = pHead;
        ListNode pre = dummy;

        while(p != null && p.next != null) {
            if(p.next.val == p.val) {
                while(p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
                p = p.next;
                pre.next = p;

            } else {
                pre = p;
                p = p.next;
            }


        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode res = new CircleListEntry().deleteDuplication(node1);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
