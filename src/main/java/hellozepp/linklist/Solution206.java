package hellozepp.linklist;

import hellozepp.ListNode;
import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

/**
 * 反转单向链表
 *
 * 难度 1.5星
 *
 *
 * FIXME
 */
public class Solution206 {

    //null 1 2 3 4
    // prev cur next 每次把cur指给前面,cur切换到下一个
    public MyLinkedList solution(MyLinkedList root) {
        MyLinkedList prev = null;
        MyLinkedList cur = root;
        while (cur != null) {
            MyLinkedList next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 2, 3, 4, 5});
        MyLinkedList.printLinkedList(linkedList);
        MyLinkedList solution = new Solution206().solution(linkedList);
        MyLinkedList.printLinkedList(solution);
    }

    /**
     *
     * 我们先让头结点的next域指向结点a2，
     * 再让结点a1的next域指向结点a3，
     * 最后将结点a2的next域指向结点a1，
     *
     * 循环
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

}