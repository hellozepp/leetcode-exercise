package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

public class a92ReverseLinkedListII {
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 2, 3, 4, 5});
        linkedList = solution(linkedList, 2, 4);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList head, int m, int n) {
        if (head == null) {
            return null;
        }
        MyLinkedList dummy = new MyLinkedList(-1);
        dummy.next = head;
        MyLinkedList prev = dummy;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        head = prev.next;
        for (int j = 0; j < n - m; j++) {
            MyLinkedList next = head.next;
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
