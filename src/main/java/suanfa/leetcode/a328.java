package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 	输入: 1->2->3->4->5->NULL
 * 	输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 	输入: 2->1->3->5->6->4->7->NULL
 * 	输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 	应当保持奇数节点和偶数节点的相对顺序。
 * 	链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class a328 {
    //    Odd Even Linked List
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 2, 3, 4, 5});
        linkedList = solution(linkedList);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList head) {
        MyLinkedList dummy1 = new MyLinkedList(0), dummy2 = new MyLinkedList(0);
        MyLinkedList cur1 = dummy1, cur2 = dummy2;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                cur1.next = head;
                cur1 = head;
                flag = false;
            } else {
                flag = true;
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }

}
