/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题23：链表中环的入口结点
 * // 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * // 环的入口结点是结点3。
 */
package offer;

public class Java23_EntryNodeInListLoop {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
	    //先判断是否有环
	    if (pHead == null || pHead.next == null) {
	        return null;
	    }
	    //走一步
	    ListNode n1 = pHead;  
	    //走两步
	    ListNode n2 = pHead;    
	    ListNode n = null;
	    while (n2 != null && n2.next != null) {
	        n2 = n2.next.next;
	        n1 = n1.next;
	        if (n2 == n1) {
	        	//记录碰头结点
	            n = n2;    
	            break;
	        }
	    }
	    //求出环中结点数量
	    int num = 0;
	    //n的镜像
	    ListNode temp = n;    
	    do {
	        temp = temp.next;
	        num++;
	    } while (temp != n);
	    ListNode node1 = pHead;
	    ListNode node2 = pHead;
	    for (int i = 0; i < num; i++) {
	        node1 = node1.next;
	    }
	    while (node1 != node2) {
	        node1 = node1.next;
	        node2 = node2.next;
	    }
	    return node1;
	}
}