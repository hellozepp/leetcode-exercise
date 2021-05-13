package leetcodeAll.leetcode2;

import others.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private TreeNode pre;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
