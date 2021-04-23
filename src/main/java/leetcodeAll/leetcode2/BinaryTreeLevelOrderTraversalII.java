package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root != null) {
            if (res.size() == level)
                res.add(new ArrayList<>());
            res.get(level).add(root.val);
            levelOrder(root.left, res, level + 1);
            levelOrder(root.right, res, level + 1);
        }
    }
}
