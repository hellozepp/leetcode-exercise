package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

/**
 * 下面题目相反
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * 输入2个链表 是逆序的 然后计算结果 逆序输出
 * <p>
 * 就是  342 +465= 807  =》7-0-8
 * <p>
 * 难度2星
 */
public class a445 {
    public MyLinkedList solution(MyLinkedList l1, MyLinkedList l2) {
        MyLinkedList pre = new MyLinkedList(0);
        MyLinkedList opt = pre;
        int carry = 0;
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            MyLinkedList cur = new MyLinkedList(sum % 10);
            pre.next = cur;
            pre = cur;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
        }
        opt = reverseLinkedList(opt.next);
        return opt;
    }

    private MyLinkedList reverseLinkedList(MyLinkedList l1) {
        MyLinkedList head = null;
        MyLinkedList cur = l1;
        while (cur != null) {
            MyLinkedList next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{3, 4, 2});
        MyLinkedList linkedList2 = MyLinkedList.createLinkedList(new int[]{4, 6, 5});
        MyLinkedList solution = new a445().solution(linkedList, linkedList2);
        MyLinkedList.printLinkedList(solution);

    }
}

