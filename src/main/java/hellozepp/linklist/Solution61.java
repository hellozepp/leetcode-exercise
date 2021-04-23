package hellozepp.linklist;

import hellozepp.ListNode;

/**
 * 旋转 链表 从第k个节点
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 难度2星
 *
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - k % i; j > 0; j--) //Get the i-k%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}