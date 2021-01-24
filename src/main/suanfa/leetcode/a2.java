package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

public class a2 {
    //    Add Two Numbers
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{3, 4, 2});
        MyLinkedList linkedList2 = MyLinkedList.createLinkedList(new int[]{4, 5, 6});//7->9->8->NULL
        MyLinkedList l3 = solution(linkedList, linkedList2);
        MyLinkedList.printLinkedList(l3);
    }

    private static MyLinkedList solution(MyLinkedList l1, MyLinkedList l2) {
        MyLinkedList pre = new MyLinkedList(0);
        MyLinkedList head = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            MyLinkedList cur = new MyLinkedList(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cur.val = sum%10;
            carry = sum/10;
            pre.next = cur;
            pre = pre.next;
            l1 = l1==null? null :l1.next;
            l2 = l2==null? null :l2.next;
        }
        return head.next;
    }
}
