package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * @author Watcher
 *
 */
public class AddTwoNumbers {

    /**
     * 链表实现两数相加，注意进位和最后一位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1); // new listnode for return
        ListNode res = preHead;
        int a = 0; // a=1 if sum of two number >=10
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + a;
            res.next = new ListNode(sum % 10);
            a = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        if (a == 0) {
            res.next = l1 == null ? l2 : l1;
        } else {
            if (l1 == null && l2 == null) {
                res.next = new ListNode(a);
            } else {
                ListNode tmp = l1 == null ? l2 : l1;
                while (tmp != null) {
                    int sum = tmp.val + a;
                    res.next = new ListNode(sum % 10);
                    a = sum / 10;
                    tmp = tmp.next;
                    res = res.next;
                }
                if (a == 1)
                    res.next = new ListNode(1);
            }
        }

        return preHead.next;
    }
}
