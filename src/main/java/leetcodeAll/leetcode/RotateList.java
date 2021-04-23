package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 61. Rotate List
 * 
 * @author Watcher
 *
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int cnt = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			cnt++;
		}
		k = cnt - k % cnt;
		if (k == cnt)
			return head;
		tail.next = head; // 连成环
		while (--k > 0)
			head = head.next;
		ListNode res = head.next;
		head.next = null;
		return res;
	}

	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		int cnt = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			cnt++;
		}
		k = cnt - k % cnt;
		if (k == cnt)
			return head;
		while (--k > 0)
			head = head.next;
		tail.next = preHead.next;
		preHead.next = head.next;
		head.next = null;
		return preHead.next;
	}
}
