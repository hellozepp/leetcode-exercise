package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

public class a328 {
//    Odd Even Linked List
     public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1,2,3,4,5});
        linkedList = solution(linkedList);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList head) {
        MyLinkedList dummy1 = new MyLinkedList(0),dummy2 = new MyLinkedList(0);
        MyLinkedList cur1 = dummy1,cur2 = dummy2;
        boolean flag = true;
        while (head!=null){
            if (flag) {
                cur1.next = head;
                cur1 = head;
                flag = false;
            }else {
                flag =true;
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
