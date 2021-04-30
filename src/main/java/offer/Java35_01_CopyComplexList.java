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
import java.util.HashMap;

public class Java35_01_CopyComplexList {
	/** 使用hashMap映射原链表，牺牲O(N)空间换时间 */
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
		    return null;
		}
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		//复制链表头节点
		RandomListNode newHead = new RandomListNode(pHead.label);
		RandomListNode pre = pHead;
		RandomListNode newPre = newHead;
		map.put(pre, newPre);
		
		//第一步，hashMap保存，原链表节点映射复制链表节点
		while (pre.next != null) {
		    newPre.next = new RandomListNode(pre.next.label);
		    pre = pre.next;
		    newPre = newPre.next;
		    map.put(pre, newPre);
		}
		
		//第二步，找到对应的random
		pre = pHead;
		newPre = newHead;
		
		while (newPre != null) {
		    newPre.random = map.get(pre.random);
		    pre = pre.next;
		    newPre = newPre.next;
		}
		
		return newHead;
	}
}