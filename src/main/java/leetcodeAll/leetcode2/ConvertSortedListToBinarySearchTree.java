package leetcodeAll.leetcode2;

import others.ListNode;
import others.TreeNode;

import java.util.ArrayList;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 转换成数组解法，耗时4ms
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return Array2Tree(list, 0, list.size() - 1);
    }

    private TreeNode Array2Tree(ArrayList<Integer> list, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = Array2Tree(list, start, mid - 1);
        root.right = Array2Tree(list, mid + 1, end);
        return root;
    }

    /**
     * 直接递归版，耗时1ms
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode leftHead = head, leftEnd = head, rightHead = head;
        while (rightHead != null && rightHead.next != null) {
            leftEnd = head;
            head = head.next;
            rightHead = rightHead.next.next;
        }
        TreeNode root = new TreeNode(head.val);
        rightHead = head.next;
        leftEnd.next = null;
        if (leftEnd == head)
            leftHead = null;
        root.left = sortedListToBST(leftHead);
        root.right = sortedListToBST(rightHead);
        return root;
    }
}
