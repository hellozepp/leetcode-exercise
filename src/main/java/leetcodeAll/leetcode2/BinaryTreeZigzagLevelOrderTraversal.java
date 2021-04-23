package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 非递归版，使用栈
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean flag = true;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                while (!stack1.isEmpty()) {
                    TreeNode cur = stack1.pop();
                    list.add(cur.val);
                    if (cur.left != null)
                        stack2.push(cur.left);
                    if (cur.right != null)
                        stack2.push(cur.right);
                }
                res.add(new ArrayList<>(list));
                list.clear();
                flag = false;
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode cur = stack2.pop();
                    list.add(cur.val);
                    if (cur.right != null)
                        stack1.push(cur.right);
                    if (cur.left != null)
                        stack1.push(cur.left);
                }
                res.add(new ArrayList<>(list));
                list.clear();
                flag = true;
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
    public List<List<Integer>> zigzagLevelOrderRecur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        orderTraversal(root, 0, res);
        for (int i = 1; i < res.size(); i += 2)
            Collections.reverse(res.get(i));
        return res;
    }

    private void orderTraversal(TreeNode root, int level, List<List<Integer>> res) {
        if (root != null) {
            if (res.size() == level)
                res.add(new ArrayList<>());
            res.get(level).add(root.val);
            orderTraversal(root.left, level + 1, res);
            orderTraversal(root.right, level + 1, res);
        }
    }
}
