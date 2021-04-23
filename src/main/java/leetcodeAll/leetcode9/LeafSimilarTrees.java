package leetcodeAll.leetcode9;

import java.util.ArrayList;

import others.TreeNode;

/**
 * 872. Leaf-Similar Trees
 * 
 * Consider all the leaves of a binary tree. From left to right order, the values of those leaves
 * form a leaf value sequence.
 * 
 * @author Watcher
 *
 */
public class LeafSimilarTrees {

	/**
	 * 遍历二叉树，将叶节点放入list，比较两个list即可
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		putLeaves(root1, list1);
		putLeaves(root2, list2);
		return list1.equals(list2);
	}

	private void putLeaves(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			list.add(root.val);
		putLeaves(root.left, list);
		putLeaves(root.right, list);
	}
}
