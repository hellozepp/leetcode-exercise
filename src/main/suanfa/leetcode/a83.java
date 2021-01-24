package suanfa.leetcode;

import org.Collection.mapandset.HashMapTest;
import suanfa.playWithAlgorithmInterview.linkedlist.MyLinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class a83 {
    //    Remove Duplicates from Sorted List
    public static void main(String[] args) {
        MyLinkedList linkedList = MyLinkedList.createLinkedList(new int[]{1, 2, 2, 3});
        linkedList = solution(linkedList);
        MyLinkedList.printLinkedList(linkedList);
    }

    private static MyLinkedList solution(MyLinkedList root) {
        MyLinkedList curr = root;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return root;
    }
}
