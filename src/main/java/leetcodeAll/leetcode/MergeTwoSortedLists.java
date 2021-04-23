package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 * 
 * @author Watcher
 *
 */
public class MergeTwoSortedLists {

	/**
	 * 递归版
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	/**
	 * 非递归版
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode preHead = new ListNode(-1);
		ListNode pre = preHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
				pre = pre.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
				pre = pre.next;
			}
		}
		pre.next = l1 == null ? l2 : l1;
		return preHead.next;
	}
}
