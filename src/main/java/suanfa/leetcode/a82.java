package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;


public class a82 {
    /**
     * 给出一个有序链表，删除其中所有重复元素，使得每个元素只保留一次。
     * - 如 1->1->2，返回1->2
     * - 如 1->1->1->2->3->3，返回1->2->3
     */
    public MyLinkedList solution(MyLinkedList linkedList) {
        if (linkedList == null || linkedList.size == 0) {
            return null;
        }
        MyLinkedList cur = new MyLinkedList(0);
        cur.next = linkedList;
        while (cur.next != null) {
            MyLinkedList next = cur.next;
            if (next.val == cur.val) {
                cur.next = next.next;
                linkedList.size--;
            } else {
                cur = next;
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 1, 1, 2, 3, 3});
        MyLinkedList solution = new a82().solution(linkedList);
        MyLinkedList.printLinkedList(solution);
        System.out.println(solution.size);
    }
}
