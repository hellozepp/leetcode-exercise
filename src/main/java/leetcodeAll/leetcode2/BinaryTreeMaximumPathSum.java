package leetcodeAll.leetcode2;

import others.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        help(root);
        return res;
    }

    private int res = Integer.MIN_VALUE;

    private int help(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int rootVal = root.val;
        int leftVal = Math.max(help(root.left), 0);
        int rightVal = Math.max(0, help(root.right));
        res = Math.max(res, rootVal + leftVal + rightVal);
        return rootVal + Math.max(leftVal, rightVal);
    }

    public int maxPathSum2(TreeNode root) {
        ReturnDate data = help2(root);
        res = Math.max(res,data.curMax);
        return res;
    }

    public static class ReturnDate {
        private int maxDepth;
        private int curMax;
        public ReturnDate(int maxDepth, int curMax) {
            this.maxDepth = maxDepth;
            this.curMax = curMax;
        }
    }

    private ReturnDate help2(TreeNode root) {
        if (root == null)
            return new ReturnDate(0, Integer.MIN_VALUE);
        ReturnDate leftDate = help2(root.left);
        ReturnDate rightDate = help2(root.right);
        int maxDepth = Math.max(leftDate.maxDepth,rightDate.maxDepth)+root.val;
        int curMax = Math.max(leftDate.curMax, rightDate.curMax);
        curMax = Math.max(curMax, leftDate.maxDepth + root.val + rightDate.maxDepth);
        res = Math.max(res, curMax);
        return new ReturnDate(Math.max(0, maxDepth), curMax);
    }
}
