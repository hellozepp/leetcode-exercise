package leetcodeAll.leetcode9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import others.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 * 
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * 
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * 
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * 
 * Return the node with the largest depth such that it contains all the deepest nodes in its
 * subtree.
 * 
 * @author Watcher
 *
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

	/**
	 * 一开始实现的版本，耗时5ms
	 * 
	 * 用的集合较多，按层次遍历，用map存放节点和父节点的映射关系，list中存放当前层的节点，最后list中只剩下最后一层节点，然后遍历list，
	 * 将其父节点存入set，当set中只剩下一个节点，即为所求
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			list.clear();
			while (size-- > 0) {
				root = queue.poll();
				list.add(root);
				if (root.left != null) {
					queue.offer(root.left);
					map.put(root.left, root);
				}
				if (root.right != null) {
					queue.offer(root.right);
					map.put(root.right, root);
				}
			}

		}
		if (list.size() == 1)
			return list.get(0);
		for (TreeNode n : list) {
			set.add(map.get(n));
		}
		while (set.size() > 1) {
			list = new ArrayList<TreeNode>(set);
			set.clear();
			for (TreeNode n : list) {
				set.add(map.get(n));
			}
		}

		return new ArrayList<TreeNode>(set).get(0);
	}

	/**
	 * 利用平衡二叉树的性质，所求即为最深节点及以上左右子树深度一样的节点
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode subtreeWithAllDeepest2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		while (root != null) {
			int left = depthOfNode(root.left, 1);
			int right = depthOfNode(root.right, 1);
			if (left == right)
				return root;
			root = left > right ? root.left : root.right;
		}
		return root;
	}

	// 求当前节点的最大深度
	private int depthOfNode(TreeNode n, int dep) {
		if (n == null)
			return dep - 1;
		return Math.max(depthOfNode(n.left, dep + 1), depthOfNode(n.right, dep + 1));
	}
}
