package leetcodeAll.leetcode2;

import others.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA.next != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB.next != null) {
            curB = curB.next;
            lenB++;
        }
        if (curA != curB)
            return null;
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0)
                curA = curA.next;
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA;
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0)
                curB = curB.next;
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA;
        }
    }
}
