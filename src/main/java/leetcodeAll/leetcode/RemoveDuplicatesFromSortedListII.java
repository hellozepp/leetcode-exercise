package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * 
 * @author Watcher
 *
 */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n.next = n2;
		n2 = n3;
		System.out.println(n.next.val);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		if (head.next != null && head.val == head.next.val) {
			while (head.next != null && head.val == head.next.val)
				head = head.next;
			return deleteDuplicates(head.next);
		} else
			head.next = deleteDuplicates(head.next);
		return head;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		head = getHead(head);
		if (head == null || head.next == null)
			return head;
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		while (head != null) {
			head.next = getHead(head.next); // 返回第一个不重复的节点
			head = head.next;
		}
		return preHead.next;
	}

	private ListNode getHead(ListNode head) {
		if (head == null || head.next == null || head.val != head.next.val)
			return head;
		int val = head.val;
		while (head != null && head.val == val)
			head = head.next;
		return getHead(head);
	}
}
