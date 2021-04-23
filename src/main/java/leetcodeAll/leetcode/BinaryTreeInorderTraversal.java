package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import others.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal
 * 
 * @author Watcher
 *
 */
public class BinaryTreeInorderTraversal {

	/**
	 * 非递归版
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}

	/**
	 * 递归版
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorder(res, root);
		return res;
	}

	private void inorder(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		inorder(res, root.left);
		res.add(root.val);
		inorder(res, root.right);
	}

}
