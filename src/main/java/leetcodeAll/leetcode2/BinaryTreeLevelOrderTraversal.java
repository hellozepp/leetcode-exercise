package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 迭代版层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode right = root;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
            if (cur == right) {
                res.add(new ArrayList<>(list));
                list.clear();
                right = ((LinkedList<TreeNode>) queue).peekLast();
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
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        levelTraversal(root, 0, res);
        return res;
    }

    private void levelTraversal(TreeNode root, int level, List<List<Integer>> res) {
        if (root != null) {
            if (res.size() == level)
                res.add(new ArrayList<>());
            res.get(level).add(root.val);
            levelTraversal(root.left, level + 1, res);
            levelTraversal(root.right, level+1, res);
        }
    }
}
