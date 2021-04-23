package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {
    List<Integer> list = new ArrayList<>();

    /**
     * 递归版
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /**
     * 迭代版：使用辅助栈
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.val);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        return list;
    }

    /**
     * 迭代版：Morris遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        TreeNode mostRight, cur = root;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    help(cur.left);
                }
            }
            cur = cur.right;
        }
        help(root);
        return list;
    }

    private void help(TreeNode cur) {
        if (cur == null)
            return;
        TreeNode tail = reverse(cur);
        while (tail != null) {
            list.add(tail.val);
            tail = tail.right;
        }
        reverse(cur);
    }

    private TreeNode reverse(TreeNode cur) {
        TreeNode pre = null, next = null;
        while (cur != null) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 迭代版：Morris遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal4(TreeNode root) {
        TreeNode mostLeft, cur = root;
        while (cur != null) {
            mostLeft = cur.right;
            if (mostLeft != null) {
                while (mostLeft.left != null && mostLeft.left != cur)
                    mostLeft = mostLeft.left;
                if (mostLeft.left == null) {
                    list.add(0, cur.val);
                    mostLeft.left = cur;
                    cur = cur.right;
                    continue;
                } else
                    mostLeft.left = null;
            } else
                list.add(0, cur.val);
            cur = cur.left;
        }
        return list;
    }
}
