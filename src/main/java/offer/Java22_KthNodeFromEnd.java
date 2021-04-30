/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题22：链表中倒数第k个结点
 * // 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * // 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * // 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * // 值为4的结点。
 */
package offer;

public class Java22_KthNodeFromEnd {
	public ListNode FindKthToTail(ListNode head,int k) {
	    if (head == null || k <= 0) {
	        return null;
	    }
	    ListNode preNode = head;
	    ListNode lastNode = head;
	    for (int i = 0; i < k - 1; i++) {
	        if (preNode.next != null) {
	            preNode = preNode.next;
	        }
	        else {
	            return null;
	        }
	    }
	    while (preNode.next != null) {
	        preNode = preNode.next;
	        lastNode = lastNode.next;
	    }
	    return lastNode;
	}
}