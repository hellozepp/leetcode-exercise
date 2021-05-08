package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

public class a206ReverseLinkedList {

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

    public MyLinkedList solution1(MyLinkedList head) {
        MyLinkedList cur = head;
        MyLinkedList pre = null;
        while (cur != null) {
            MyLinkedList next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 2, 3, 4, 5});
        MyLinkedList.printLinkedList(linkedList);
        MyLinkedList solution = new a206ReverseLinkedList().solution(linkedList);
        MyLinkedList.printLinkedList(solution);
    }
}
