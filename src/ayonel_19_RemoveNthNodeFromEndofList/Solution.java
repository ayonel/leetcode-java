package ayonel_19_RemoveNthNodeFromEndofList;

/**
 * Remove Nth Node From End of List
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-08 15:15
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：两个指针，一快一慢
 **/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode last = head;
        int count = 0;
        while(pre != null) {
            pre = pre.next;
            if(count <= n) {
                count++;
            } else {
                last = last.next;
            }
        }

        if(count <= n){
            head = last.next;

            return head;
        }

        if(last.next != null)
            last.next = last.next.next;
        else
            head = null;



        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        new Solution().removeNthFromEnd(node1, 1);
    }

}
