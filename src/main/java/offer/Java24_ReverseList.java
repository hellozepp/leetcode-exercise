/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题24：反转链表
 * // 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * // 头结点。
 */
package offer;

public class Java24_ReverseList {
	public ListNode ReverseList(ListNode head) {
	    if (head == null)
	        return null;
	    if (head.next == null)
	        return head;
	    ListNode pPre = null;
	    ListNode p = head;
	    ListNode pNext = head.next;
	    ListNode newHead = null;
	    while (p != null) {
	    	//记录下来后面的节点
	        pNext = p.next;    
	        if (pNext == null) {
	            newHead = p;
	        }
	        //这里的方向已经转变
	        p.next = pPre;     
	        pPre = p;
	        //将保存的后面的节点作为下一次循环的p
	        p = pNext;         
	    }
	    return newHead;
	}
}