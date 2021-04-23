package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 86. Partition List
 * 
 * @author Watcher
 *
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode lessHead = new ListNode(-1);
		ListNode moreHead = new ListNode(-1);
		ListNode less = lessHead, more = moreHead;
		while (head != null) {
			if (head.val < x) {
				less.next = head; // 第一次起作用时，和lessHead是同一对象，next指向同样赋给了lessHead。之后less指向其他对象
				less = less.next;
			} else {
				more.next = head;
				more = more.next;
			}
			head = head.next;
		}
		less.next = moreHead.next;
		more.next = null;
		return lessHead.next;
	}
}
