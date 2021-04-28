package hellozepp.linklist;

import hellozepp.ListNode;

/**
 * 删除 最后第N个节点
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 * 难度2星
 *
 * FIXME
 */
public class Solution19 {


    /**
     * 2 points 思路
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;

        //先移动 fast到 length - n的位置
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        //再移动fast到尾部 那么slow现在的位置就是 n
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //delete
        slow.next = slow.next.next;

        return head;
    }


}