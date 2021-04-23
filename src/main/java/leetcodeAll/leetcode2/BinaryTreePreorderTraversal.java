package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {

    /**
     * 迭代版，Morris遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode mostRight;
        while (root != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != root)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    list.add(root.val);
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else
                    mostRight.right = null;
            } else
                list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 迭代版，使用辅助栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return list;
    }

    /**
     * 递归版
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        return help(root, new ArrayList<>());
    }

    private List<Integer> help(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return list;
        list.add(root.val);
        help(root.left, list);
        help(root.right, list);
        return list;
    }
}
