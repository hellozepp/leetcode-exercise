package hellozepp.tree;

import hellozepp.TreeNode;

/**
 * 检测二叉树是否是对称的  (结构是相对的 值也是相对的)
 * For example,  [1,2,2,3,4,4,3]
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 难度2星
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {

        if(root==null)return  true;

        return isSameTree(root.left,root.right);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val)
            return isSameTree(p.right, q.left) && isSameTree(p.left, q.right);

        return false;
    }
}