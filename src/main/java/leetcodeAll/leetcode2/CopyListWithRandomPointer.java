package leetcodeAll.leetcode2;

import others.RandomListNode;

/**
 * 138. Copy List with Random Pointer
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode copyHead = head.next;
        cur = head;
        RandomListNode copy = copyHead;
        while (copy.next != null) {
            cur.next = copy.next;
            cur = cur.next;
            copy.next = cur.next;
            copy = copy.next;
        }
        cur.next = null;
        return copyHead;
    }
}
