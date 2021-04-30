/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题6：从尾到头打印链表
 * // 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
package offer;
import java.util.Stack;
import java.util.ArrayList;

/** 栈 */
public class Java06_01_PrintListInReversedOrder {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			ArrayList list = new ArrayList();
			return list;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			arr.add(stack.pop());
		}
		return arr;
	}
}
