/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题18（一）：在O(1)时间删除链表节点
 * // 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */
package offer;

public class Java18_01_DeleteNodeInList {
	public void deleteNode (ListNode head, ListNode deleteNode) {
		if (head == null || deleteNode == null) 
			return;
		
		//要删除的节点不是尾节点
		if (deleteNode.next != null) {
			deleteNode.val = deleteNode.next.val;
			deleteNode.next = deleteNode.next.next;
		}
		else if (head == deleteNode) {
			//链表只有一个节点，删除头节点（也是尾节点）
			head = null;
		}
		else {
			//链表中有多个节点，删除尾节点
			ListNode node = head;
			while (node.next != deleteNode) {
				//找到倒数第二个节点
				node = node.next;
			}
			node.next = null;
		}
	}
}
