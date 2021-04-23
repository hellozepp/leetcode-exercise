package leetcodeAll.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import others.ListNode;

/**
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 * 
 * 
 * @author Watcher
 *
 */
public class MergeKSortedLists {

	/**
	 * 归并版本，耗时7ms
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		int len = lists.length;
		if (len == 1)
			return lists[0];
		while (len > 1) {
			for (int i = 0; i < len / 2; i++) {
				lists[i] = merge2List(lists[i], lists[len - 1 - i]);
			}
			len = (len + 1) / 2;
		}
		return lists[0];
	}

	/**
	 * 归并两路链表
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private ListNode merge2List(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge2List(l1.next, l2);
			return l1;
		} else {
			l2.next = merge2List(l1, l2.next);
			return l2;
		}
	}

	/**
	 * 优先级队列版本，耗时12ms
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		int len = lists.length;
		if (len == 1)
			return lists[0];
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (int i = 0; i < len; i++) {
			if (lists[i] != null)
				pq.offer(lists[i]);
		}
		ListNode preHead = new ListNode(-1);
		ListNode cur = preHead;
		while (!pq.isEmpty()) {
			if (pq.size() == 1) {
				cur.next = pq.poll();
				return preHead.next;
			}
			ListNode node = pq.poll();
			cur.next = node;
			cur = cur.next;
			if (cur.next != null)
				pq.offer(cur.next);
		}
		return preHead.next;
	}

}
