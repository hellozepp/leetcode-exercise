package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a404 {

    private int sum = 0;

    private int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sumOfLeftLeaves(root.left);
            }
        }
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
