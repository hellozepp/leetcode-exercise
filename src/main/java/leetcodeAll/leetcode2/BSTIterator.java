package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return val;
    }
}

class BSTIterator2 {
    TreeNode cur;

    public BSTIterator2(TreeNode root) {
        cur = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return cur != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (cur.left != null) {
            TreeNode mostRight = cur.left;
            while (mostRight.right != null && mostRight.right != cur)
                mostRight = mostRight.right;
            if (mostRight.right == null) {
                mostRight.right = cur;
                cur = cur.left;
            } else {
                mostRight.right = null;
                break;
            }
        }
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}