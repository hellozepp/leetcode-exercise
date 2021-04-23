package leetcodeAll.leetcode;

import java.util.Stack;

import others.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * 
 * @author Watcher
 *
 */
public class ValidateBinarySearchTree {

	boolean res = true;
	long cur = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return res;
		res = res && isValidBST(root.left);
		if (cur >= root.val)
			res = false;
		cur = root.val;
		res = res && isValidBST(root.right);
		return res;
	}

	public boolean isValidBST2(TreeNode root) {
		long cur = Long.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if (cur >= root.val)
					return false;
				cur = root.val;
				root = root.right;
			}
		}
		return true;
	}
}
