package ayonel_23_MergekSortedLists;


import java.util.*;

/**
 * 23. Merge k Sorted Lists
 *
 * @author ayonel
 * @create 2017-06-09 10:15
 * @blog https://ayonel.me
 * 解题思路：递归，但是超时了。。。。,最后一个样例没过， 如果用java自带的优先队列来做，就可以，原理类似，但是可能优先队列
 * 有一些优化，不会超时
 * 解题思路2：用空间换时间，重新构造一个新链, 妈的还是超时
 *
 *
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        int MIN = Integer.MAX_VALUE;
        ListNode MINNODE = lists[0];

        int notEmptyNode = 0;
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            notEmptyNode += 1;
            if (node.val < MIN) {
                MIN = node.val;
                MINNODE = node;
            }
        }
        if (notEmptyNode == 0)
            return null;

        //移除null
        ListNode[] newLists = new ListNode[notEmptyNode];

        int j = 0;
        for (ListNode node : lists) {
            if (node != null) {
                newLists[j] = node;
                j++;
            }
        }

        for (int i = 0; i < newLists.length; i++) {
            if (newLists[i].val == MIN) {
                newLists[i] = newLists[i].next;
                break;
            }
        }

        System.out.println(notEmptyNode);
        MINNODE.next = mergeKLists(newLists);
        return MINNODE;

    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node2_2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node5;

        node2_2.next = node3;
        node3.next = node4;

        ListNode node3_3 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        node3_3.next = node6;

        ListNode[] lists = {null, node1};
        ListNode res = new Solution().mergeKListsSpace(lists);

        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public ListNode mergeKListsSpace(ListNode[] lists) {
        ListNode res = null;
        ListNode resPoint = null;
        if (lists.length == 0)
            return null;
        ListNode MINNODE = null;
        int MIN = Integer.MAX_VALUE;
        ArrayList<ListNode> arrayList = new ArrayList<>();

        //确定头结点
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            arrayList.add(node);
            if (node.val < MIN) {
                MIN = node.val;
                MINNODE = node;
            }
        }


        res = MINNODE;
        resPoint = res;
        if (arrayList.size() == 0)
            return null;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val == MIN) {
                lists[i] = lists[i].next;
                break;
            }
        }


        while (true) {
            MIN = Integer.MAX_VALUE;
            arrayList = new ArrayList<>();
            for (ListNode node : lists) {
                if (node == null) {
                    continue;
                }
                arrayList.add(node);
                if (node.val < MIN) {
                    MIN = node.val;
                    MINNODE = node;
                }
            }
            if (arrayList.size() == 0)
                break;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val == MIN) {
                    lists[i] = lists[i].next;
                    break;
                }
            }
            res.next = MINNODE;
            res = res.next;
        }
        return resPoint;
    }


    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}

