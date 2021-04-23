package leetcodeAll.leetcode;

import others.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number
 * of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * @author Watcher
 *
 */
public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ReverseNodesInKGroup so = new ReverseNodesInKGroup();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		so.reverseKGroup(head, 2);
	}

	/**
	 * 递归版
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		int cnt = k;
		while (cnt > 0 && cur != null) {
			cur = cur.next; // cur移动到第k+1位置
			cnt--;
		}
		if (cnt == 0) {
			cur = reverseKGroup(cur, k);
			while (cnt++ < k) {
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
			}
			head = cur;
		}
		return head;
	}

	/**
	 * 非递归版
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup2(ListNode head, int k) {
		int cnt = k;
		ListNode preHead = new ListNode(-1);
		ListNode pre = preHead;
		pre.next = head;
		ListNode cur = head;
		while (cur != null) {
			while (cur != null && --cnt > 0) {
				cur = cur.next;
			}
			if (cnt > 0)
				return preHead.next;
			ListNode tmp = cur.next;
			ListNode[] res = reverseK(head, k);
			pre.next = res[1];
			res[0].next = tmp;
			pre = res[0];
			cur = tmp;
			head = cur;
			cnt = k;
		}
		return preHead.next;
	}

	private ListNode[] reverseK(ListNode head, int k) {
		ListNode[] res = new ListNode[2];
		res[0] = head;
		ListNode cur = head.next;
		head.next = null;
		ListNode node = head;
		while (--k > 0) {
			ListNode next = cur.next;
			cur.next = node;
			node = cur;
			cur = next;
		}
		res[1] = node;
		return res;
	}

}
