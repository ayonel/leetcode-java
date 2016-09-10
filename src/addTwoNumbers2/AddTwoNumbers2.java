package addTwoNumbers2;

import java.util.List;

/**
 * @author ayonel
 * @created_at 16/9/10
 */

public class AddTwoNumbers2 {
    public static void main(String[] args) {

        ListNode num1 = new ListNode(9);
        num1.next = new ListNode(9);
        num1.next.next = new ListNode(9);

        ListNode num2 = new ListNode(1);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);
        addTwoNumbers(num1, num2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumList = new ListNode(0);
        ListNode result = sumList;
        while (true) {

            if (l1.next == null && l2.next == null) {
                //才要结束运算
                sumList.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) >= 10? 1: 0;
                if (carry == 1) {
                    sumList.next = new ListNode(1);
                }
                break;
            }

            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);

                sumList.val = (l1.val + l2.val+ carry) % 10;
                carry = (l1.val + l2.val + carry) >= 10? 1: 0;
                sumList.next = new ListNode(0);
                sumList = sumList.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if (l1.next != null && l2.next == null) {
                l2.next = new ListNode(0);
                sumList.val = (l1.val + l2.val+ carry) % 10;
                carry = (l1.val + l2.val + carry) >= 10? 1: 0;

                sumList.next = new ListNode(0);
                sumList = sumList.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            sumList.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) >= 10? 1: 0;
            sumList.next = new ListNode(0);
            sumList = sumList.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
