package leetcodeAll.leetcode2;

import others.ListNode;

/**
 * 148. Sort List
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, end1 = null;
        while (fast != null && fast.next != null) {
            end1 = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        end1.next = null;
        ListNode node1 = sortList(head), node2 = sortList(slow);
        ListNode preHead = new ListNode(-1), cur = preHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }
        cur.next = node1 == null ? node2 : node1;
        return preHead.next;
    }
}
