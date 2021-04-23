package leetcodeAll.leetcode3;

import others.ListNode;

/**
 * 203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return null;
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
