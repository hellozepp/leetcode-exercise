package leetcodeAll.leetcode2;

import others.TreeNode;

/**
 * 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return flag;
    }

    private boolean flag = true;

    private int maxDepth(TreeNode root) {
        if (!flag)
            return -1;
        if (root == null)
            return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        if (left - right > 1 || left - right < -1)
            flag = false;
        return left >= right ? left : right;
    }
}
