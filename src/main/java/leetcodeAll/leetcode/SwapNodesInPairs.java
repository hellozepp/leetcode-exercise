package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * @author Watcher
 *
 */
public class SwapNodesInPairs {

	/**
	 * 递归版
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next.next; // record
		ListNode tmp = head.next;
		head.next = next;
		tmp.next = head;
		head = tmp;
		head.next.next = swapPairs(next); // recursion
		return head;
	}

	/**
	 * 非递归版
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode preHead = new ListNode(-1);
		ListNode pre = preHead;
		while (head != null && head.next != null) {
			ListNode next2 = head.next.next;
			ListNode next1 = head.next;
			head.next = next2;
			next1.next = head;
			pre.next = next1;
			pre = next1.next;
			head = next2;
		}
		return preHead.next;
	}
}
