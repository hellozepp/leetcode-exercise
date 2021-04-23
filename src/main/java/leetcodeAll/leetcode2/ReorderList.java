package leetcodeAll.leetcode2;

import others.ListNode;

/**
 * 143. Reorder List
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode left = head, right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        right = left.next;
        left.next = null;
        while (right != null) {
            ListNode next_tmp = right.next;
            right.next = left;
            left = right;
            right = next_tmp;
        }
        right = left;
        left = head;
        while (right.next != null) {
            ListNode right_tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = right_tmp;
        }
    }
}
