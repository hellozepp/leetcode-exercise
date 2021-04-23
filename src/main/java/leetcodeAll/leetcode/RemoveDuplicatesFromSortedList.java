package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * @author Watcher
 *
 */
public class RemoveDuplicatesFromSortedList {
	/**
	 * 递归版简单实现
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		while (head.next != null && head.val == head.next.val)
			head = head.next;
		head.next = deleteDuplicates(head.next);
		return head;
	}

	/**
	 * 非递归版
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode cur = head;
		ListNode next;
		while (cur != null) {
			next = cur.next;
			while (next != null && cur.val == next.val)
				next = next.next;
			cur.next = next;
			cur = next;
		}
		return head;
	}

}
