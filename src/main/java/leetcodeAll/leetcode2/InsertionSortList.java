package leetcodeAll.leetcode2;

import others.ListNode;

/**
 * 147. Insertion Sort List
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(-1);
        while (head != null) {
            ListNode cur = preHead, nextHead = head.next;
            while (cur.next != null && cur.next.val < head.val)
                cur = cur.next;
            head.next = cur.next;
            cur.next = head;
            head = nextHead;
        }
        return preHead.next;
    }
}
