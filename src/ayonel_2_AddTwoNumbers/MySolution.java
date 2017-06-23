package ayonel_2_AddTwoNumbers;

/**
 * @author ayonel_113_PathSumII
 * @created_at 16/9/10
 */

public class MySolution {

    /**
     * 主函数调用
     * @param args
     */
    public static void main(String[] args) {
        ListNode num1 = new ListNode(1);
        num1.next = new ListNode(8);
//        num1.next.next = new ListNode(3);

        ListNode num2 = new ListNode(0);
//        num2.next = new ListNode(6);
//        num2.next.next = new ListNode(4);
        addTwoNumbers(num1, num2);

    }

    //核心算法
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
    public static ListNode addTwoNumbersAnother(ListNode l1, ListNode l2) {

        //这种方法会在末尾多余一个ListNode(0);
        //但java中的内存自己控制不了。。。
        //所以参考标准答案,算出当前和的个位,直接再new ListNode((x+y+carry)%10)
        //当然C++、C中是可以的
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        ListNode curr = new ListNode(0);
        ListNode result = curr;
        while (p != null || q != null) {

            int x = (p==null ? 0: p.val);
            int y = (q==null ? 0: q.val);
            curr.val = (x +y + carry) % 10;
            carry = (x + y + carry) >= 10?1:0;
            System.out.println("x:"+x);
            System.out.println("y:"+y);
            System.out.println("crary:"+carry);



            curr.next = new ListNode(0);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(1);
        }
        System.out.println("&&&&&&&&&&&&&");

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        return result;


    }

}
