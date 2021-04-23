package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import others.TreeNode;

/**
 * 95. Unique Binary Search Trees II
 * 
 * @author Watcher
 *
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n < 1)
			return new ArrayList<TreeNode>();
		return generate(1, n, new HashMap<Integer, List<TreeNode>>());
	}

	private List<TreeNode> generate(int start, int end, HashMap<Integer, List<TreeNode>> map) {
		List<TreeNode> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}
		int key = (start << 16) | end;
		if (map.containsKey(key))
			return map.get(key);
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generate(start, i - 1, map);
			List<TreeNode> right = generate(i + 1, end, map);
			for (TreeNode l : left)
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
		}
		map.put(key, res);
		return res;
	}
}
