package hellozepp.linklist;


import com.alibaba.fastjson.JSON;
import hellozepp.ListNode;


/**
 * 删除对应值 val的节点
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * 难度1星
 */
public class Solution203 {
    /**
     * 递归方式
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements4(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements4(head.next, val);

        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }


    }

    /*
     * 使用递归方式
     * */
    public static ListNode removeElements5(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements5(head.next, val);

        return head.val == val ? head.next : head;

    }

    /**
     * 迭代
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode curr = head, pre = start;

        while (curr != null) {
            if (curr.val == val) {
                pre = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }

        return start.next;
    }

    // 重写递归
    public static ListNode removeEl(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeEl(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        System.out.println(JSON.toJSONString(removeElements4(a, 6)));
        System.out.println(JSON.toJSONString(removeElements5(a, 6)));
        System.out.println(JSON.toJSONString(new Solution203().removeElements2(a, 6)));
    }
}