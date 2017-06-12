package ayonel_25_ReverseNodesinkGroup;

import ayonel_2_AddTwoNumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author ayonel
 * @create 2017-06-12 14:15
 * @blog https://ayonel.me
 * 解题思路：递归，审题要仔细
 **/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> list = new ArrayList<>();
        ListNode dummpy = head;
        if (k <= 1 || head == null)
            return head;
        ListNode first = null;
        int i = 0;
        for(; i < k && dummpy != null; i++) {
            list.add(dummpy);
            dummpy = dummpy.next;
        }

        first = list.get(list.size()-1);

        if (list.size() == k) {
            for(int j = list.size()-1; j > 0; j--) {
                list.get(j).next = list.get(j-1);
            }
        }

        if (i<k){
            return list.get(0);
        } else {
            list.get(0).next = reverseKGroup(dummpy, k);
        }
        return first;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        ListNode node = new Solution().reverseKGroup(node1,4);
//        System.out.println(node.val);

        while(node != null)
        {
            System.out.println(node.val+" ");
            node = node.next;
        }
    }

}
