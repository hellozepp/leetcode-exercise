package leetcodeAll.leetcode;

import others.TreeNode;

/**
 * 100. Same Tree
 * 
 * @author Watcher
 *
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null)
			return q == null;
		if (q == null)
			return p == null;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}
}
