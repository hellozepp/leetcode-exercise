/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题18（二）：删除链表中重复的结点
 * // 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * // 结点被删除之后，链表如图3.4（b）所示。
 */
package offer;

public class Java18_02_DeleteDuplicatedNode {
	public ListNode deleteDuplication(ListNode pHead) {
	    //使用虚拟头结点，方便在链表头部进行的一些操作
	    ListNode visualHead = new ListNode(-1);
	    visualHead.next = pHead;
	    //当前节点的前一个节点
        ListNode pre = visualHead;
        while(pHead != null && pHead.next != null){
            if(pHead.val == pHead.next.val){
                int value = pHead.val;
                while(pHead != null && pHead.val == value)
                    pHead = pHead.next;
                pre.next = pHead;
            }else{
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return visualHead.next;
    }
}