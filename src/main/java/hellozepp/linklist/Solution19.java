package hellozepp.linklist;

import com.alibaba.fastjson.JSON;
import hellozepp.ListNode;

/**
 * 删除 最后第N个节点
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
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
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        //先移动 fast到 length - n 的位置
        for (int i = 1; i <= n; i++) {
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

    // 重写
    public ListNode solution(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, tmp = head;
        for (int i = 1; i <= n; i++) {
            tmp = tmp.next;
        }
        while (tmp != null) {
            cur = cur.next;
            tmp = tmp.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        // 一个节点的情况
        System.out.println(JSON.toJSONString(new Solution19().removeNthFromEnd(d, 1)));
    }

}