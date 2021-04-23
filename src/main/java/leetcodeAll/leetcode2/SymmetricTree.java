package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.Stack;

/**
 * 101. Symmetric Tree
 */
public class SymmetricTree {

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        if (right == null)
            return left == null;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop(), node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
}
