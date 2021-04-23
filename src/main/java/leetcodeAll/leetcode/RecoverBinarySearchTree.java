package leetcodeAll.leetcode;

import others.TreeNode;

/**
 * 99. Recover Binary Search Tree
 * 
 * @author Watcher
 *
 */
public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		new RecoverBinarySearchTree().recoverTree(root);
	}

	TreeNode first = null;
	TreeNode second = null;
	TreeNode pre = null;
	boolean flag = true;

	public void recoverTree(TreeNode root) {
		recover(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	private boolean recover(TreeNode root) {
		if (root == null)
			return flag;
		flag = flag && recover(root.left);
		if (pre != null && pre.val > root.val && first == null)
			first = pre;
		if (first != null && pre.val > root.val)
			second = root;
		if (first != null && root.val > first.val) // 短路，一旦当前结点的值大于被交换到前面的那个结点的值，后面结点不需要再访问了
			flag = false;
		pre = root;
		flag = flag && recover(root.right);
		return flag;
	}
}
