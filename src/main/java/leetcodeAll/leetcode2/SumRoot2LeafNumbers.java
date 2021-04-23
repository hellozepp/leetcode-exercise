package leetcodeAll.leetcode2;

import others.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRoot2LeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return res;
        help(root, 0);
        return res;
    }

    private void help(TreeNode root, int val) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            res += val * 10 + root.val;
        help(root.left, val * 10 + root.val);
        help(root.right, val * 10 + root.val);
    }

    private int res = 0;

    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int val) {
        if (root == null)
            return 0;
        int cur = val * 10 + root.val;
        if (root.left == null && root.right == null)
            return cur;
        return sum(root.left, cur) + sum(root.right, cur);
    }
}
