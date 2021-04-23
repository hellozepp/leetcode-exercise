package suanfa.leetcode;

import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

public class a86 {
    //Partition List
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        linkedList = solution(linkedList, 3);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList head, int i) {
        MyLinkedList dummy1 = new MyLinkedList(0),dummy2=new MyLinkedList(0);
        MyLinkedList curr1 = dummy1,curr2 = dummy2;
        while (head!= null){
            if (head.val<i){
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head =head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
