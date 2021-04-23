package hellozepp.linklist;

import hellozepp.ListNode;

/**
 * 交换 相邻的节点
 * 难度2星
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * cur first sec (next) 交换图是一个红纽带
 * FIXME
 *
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}