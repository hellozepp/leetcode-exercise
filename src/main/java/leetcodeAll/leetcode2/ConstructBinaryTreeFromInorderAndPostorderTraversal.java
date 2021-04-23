package leetcodeAll.leetcode2;

import others.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 递归版，耗时1ms
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }

    private int inIndex = 0, posIndex = 0;

    private TreeNode buildTree(int[] inorder, int[] postorder, int val) {
        if (inIndex >= inorder.length || inorder[inorder.length - inIndex - 1] == val)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - ++posIndex]);
        root.right = buildTree(inorder, postorder, root.val);
        inIndex++;
        root.left = buildTree(inorder, postorder, val);
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        inIndex = inorder.length - 1;
        posIndex = postorder.length - 1;
        return buildTree2(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree2(int[] inorder, int[] postorder, int val) {
        if (inIndex < 0 || inorder[inIndex] == val)
            return null;
        TreeNode root = new TreeNode(postorder[posIndex--]);
        root.right = buildTree2(inorder, postorder, root.val);
        inIndex--;
        root.left = buildTree2(inorder, postorder, val);
        return root;
    }
}
