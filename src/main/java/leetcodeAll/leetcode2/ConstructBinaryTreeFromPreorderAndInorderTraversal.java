package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 递归版本1，耗时21ms
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while (inorder[i] != preorder[0])
            i++;
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        return root;
    }

    /**
     * 递归版本2，耗时10+ms
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return buildTree2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (inorder[i] != preorder[preStart])
            i++;
        root.left = buildTree2(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        root.right = buildTree2(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    /**
     * 递归版本3，耗时1-2ms，最快
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        return buildTree3(preorder, inorder, Integer.MAX_VALUE);
    }

    private int preIndex = 0, inIndex = 0;

    private TreeNode buildTree3(int[] preorder, int[] inorder, int val) {
        if (inIndex >= inorder.length || inorder[inIndex] == val)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = buildTree3(preorder, inorder, root.val);
        inIndex++;
        root.right = buildTree3(preorder, inorder, val);
        return root;
    }
}
