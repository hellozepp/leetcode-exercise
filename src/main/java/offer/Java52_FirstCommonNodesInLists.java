/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题52：两个链表的第一个公共结点
 * // 题目：输入两个链表，找出它们的第一个公共结点。
 */
package offer;

public class Java52_FirstCommonNodesInLists {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int count1 = 0;
		ListNode p1 = pHead1;
		while ( p1 != null) {
			p1 = p1.next;
			count1++;
		}
		int count2 = 0;
		ListNode p2 = pHead2;
		while ( p2 != null) {
			p2 = p2.next;
			count2++;
		}
		int flag = count1 - count2;
		if (flag > 0) {
			while (flag > 0) {
				pHead1 = pHead1.next;
				flag--;
			}
			while (pHead1 != pHead2) {
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;
			}
			return pHead1;
		}
		if (flag <= 0) {
			while (flag < 0) {
				pHead2 = pHead2.next;
				flag++;
			}
			while (pHead1 != pHead2) {
				pHead2 = pHead2.next;
				pHead1 = pHead1.next;
			}
			return pHead1;
		}
		return null;
	}
}