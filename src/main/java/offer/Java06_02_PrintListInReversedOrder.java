/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题6：从尾到头打印链表
 * // 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
package offer;
import java.util.ArrayList;

/** 递归 */
public class Java06_02_PrintListInReversedOrder {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			ArrayList list = new ArrayList();
			return list;
			}
		if (listNode != null) {
			if (listNode.next != null) {
				printListFromTailToHead(listNode.next);
			}
			arr.add(listNode.val);
			System.out.print("" + listNode.val);
		}
		return arr;
	}
}
