package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * @author Watcher
 *
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preHead = new ListNode(-1); // 指向头结点的结点，用于返回
		preHead.next = head;
		ListNode cur = preHead, node = head; // 删除cur的下一个节点，cur后面有n个节点
		while (n-- > 0) { // node先走n步
			node = node.next;
		}
		while (node != null) {
			node = node.next;
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return preHead.next;
	}
}
