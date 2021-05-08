package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 解题思路
 *
 * 这个问题和这篇文章Leetcode 328:奇偶链表（最详细解决方案！！！）中的问题很类似。我们这里同样使用双链表解决，
 * 只是这里的双链表一个是包含<x的元素，一个是包含>=x的元素。
 *
 * h1 -> 1 -> 2 -> 2
 * h2 -> 4 -> 3 -> 5
 */
public class a86 {
    //Partition List
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        linkedList = solution(linkedList, 3);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList head, int i) {
        MyLinkedList dummy1 = new MyLinkedList(0), dummy2 = new MyLinkedList(0);
        MyLinkedList curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            if (head.val < i) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
