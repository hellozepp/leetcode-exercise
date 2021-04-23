package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int level) {
        if (root == null)
            return;
        if (res.size() == level)
            res.add(root.val);
        dfs(res, root.right, level + 1);
        dfs(res, root.left, level + 1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res.add(queue.peekLast().val);
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
        }
        return res;
    }
}
