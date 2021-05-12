package hellozepp.linklist;

import com.alibaba.fastjson.JSON;
import hellozepp.ListNode;

/**
 * K 个一组翻转链表
 * 难度2星 hard
 * 题目描述：
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 解题思路：可以将链表分成n个长度为k的新链表，每次将新翻转后链表newlist重新连接到原来的链表上，最后再将不用翻转的链表连接到链表末尾即可，详情如下图所示：
 * FIXME
 *
 */
public class Solution25 {

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        //计算链表长度
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        len /= k;
        //当没有要反转链表的时候直接返回
        if (len == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = head;
        for (int i = 0; i < len; i++) {
            //newlist表示分离出来的链表
            ListNode newlist = null;
            //newhead表示分离出来链表的头
            ListNode newhead = cur;
            int count = k;
            //反转分离出来的链表
            while (count > 0) {
                tmp = cur;
                cur = cur.next;
                tmp.next = newlist;
                newlist = tmp;
                count--;
            }
            //只有当第一次反转链表时不用将首尾相连，因为只有头，所以只需要将链表原本的头
            //更新即可，在后面的链表反转中，则需要将分离出来的链表与之前的链表首尾相连
            if (i == 0) {
                head = newlist;
            } else {
                tail.next = newlist;
                tail = newhead;
            }
        }
        //链接链表剩余的部分
        while (cur != null) {
            tail.next = cur;
            tail = tail.next;
            cur = cur.next;
        }
        //返回头节点
        return head;
    }

    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        int kk = k;
        ListNode newHead = null;
        ListNode p = head;
        ListNode prev = null;
        ListNode pNext = null;
        int size = size(head);
        if (size < k) {
            return head;
        }
        while (k >= 1) {
            k--;
            pNext = p.next;
            if (k == 0) {
                newHead = p;
            }
            p.next = prev;
            prev = p;
            p = pNext;
        }
        ListNode lastNode = newHead;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        ListNode nextHead = reverseKGroup(pNext, kk);
        lastNode.next = nextHead;
        return newHead;

    }

    public int size(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    public static void main(String[] args) {
        ListNode test = null;
        ListNode test1 = test;
        test = new ListNode(1);
        System.out.println(test1);

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(JSON.toJSONString(new Solution25().reverseKGroup1(a, 3)));
    }
}