/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题35：复杂链表的复制
 * // 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * // 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * // 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
package offer;

public class Java35_02_CopyComplexList {
	/** 不借用辅助空间 */
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
			}
		RandomListNode pCur = pHead;
		//第一步：复制next 如原来是A->B->C变成A->A'->B->B'->C->C'
		while (pCur != null) {
			RandomListNode node = new RandomListNode(pCur.label);
			node.next = pCur.next;
			pCur.next = node;
			pCur = node.next;
			}
      
		//第二步
		pCur = pHead;
		//复制random, pCur是原来链表的结点, pCur.next是复制pCur的结点
		while (pCur != null) {
			if (pCur.random != null) {
				pCur.next.random = pCur.random.next;
			}
			pCur = pCur.next.next;
			}
      
		//第三步
		//复制链表的头结点
		RandomListNode head = pHead.next;
		//偶数位置为复制链表
		RandomListNode cur = head;
		//奇数位置为原链表
		pCur = pHead;
		//拆分链表
		while (pCur != null) {
			pCur.next = pCur.next.next;
			//注意最后一个复制结点的时候没有next的next
			if (cur.next != null) {
				cur.next = cur.next.next;
				}
			cur = cur.next;
			pCur = pCur.next;
			}
		return head;
		}
	}