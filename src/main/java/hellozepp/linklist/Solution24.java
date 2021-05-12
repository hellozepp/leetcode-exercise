package hellozepp.linklist;

import com.alibaba.fastjson.JSON;
import hellozepp.ListNode;

/**
 * 交换 相邻的节点 穿针引线
 * 难度2星
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * cur first sec (next) 交换图是一个红纽带
 * 解法：维护4个指针，dummy node1 node2 next, p - node2 - node1 - next,每次指完后移动dummy到node1，重置node1 node2 next
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

            current.next = second;
            first.next = second.next;
            second.next = first;
            current = first;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(JSON.toJSONString(new Solution24().swapPairs(a)));
    }
}