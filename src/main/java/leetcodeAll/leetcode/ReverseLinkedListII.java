package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 92. Reverse Linked List II
 * 
 * @author Watcher
 *
 */
public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode pre = preHead;
		ListNode cur = pre, end = pre;
		for (int i = 0; i < n - m; i++)
			end = end.next;
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
			end = end.next;
		}
		cur = pre.next;
		end = end.next;
		while (cur != end) {
			ListNode curNext = cur.next;
			cur.next = end.next;
			end.next = cur;
			cur = curNext;
		}
		pre.next = cur;
		return preHead.next;
	}
}
