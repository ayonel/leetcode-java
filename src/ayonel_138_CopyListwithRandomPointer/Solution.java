package ayonel_138_CopyListwithRandomPointer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ayonel
 * @create 2017-06-28 22:45
 * @blog https://ayonel.me
 **/

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        ArrayList<RandomListNode> originList = new ArrayList<>();
        ArrayList<RandomListNode> newList = new ArrayList<>();

        RandomListNode p = head;
        RandomListNode pre = new RandomListNode(head.label);
        RandomListNode newHead = pre;
        originList.add(p);
        newList.add(pre);

        p = p.next;
        while (p != null) {
            originList.add(p);
            RandomListNode node = new RandomListNode(p.label);
            newList.add(node);
            pre.next = node;
            pre = node;
            p = p.next;
        }

        //重置p, pre 计算random
        p = head;
        pre = newHead;
        while(p != null) {
            if (p.random != null) {
                int index = originList.indexOf(p.random);
                pre.random = newList.get(index);
            }
            p = p.next;
            pre = pre.next;
        }
        return newHead;

    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;

        new Solution().copyRandomList(node1);
    }
}
