/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题25：合并两个排序的链表
 * // 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * // 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * // 表3所示。
 */
package offer;

public class Java25_MergeSortedLists {
	public ListNode Merge(ListNode list1,ListNode list2) {
	    if (list1 == null) {
	        return list2;
	    }
	    else if (list2 == null) {
	        return list1;
	    }
	    ListNode mergeHead = null;
	    if (list1.val < list2.val) {
	        mergeHead = list1;
	        mergeHead.next = Merge(list1.next, list2);
	    }
	    else {
	        mergeHead = list2;
	        mergeHead.next = Merge(list1, list2.next);
	    }
	    return mergeHead;
	}
}