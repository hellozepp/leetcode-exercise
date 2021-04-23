package hellozepp.tree;

import hellozepp.TreeNode;

/**
 *
 *
 * 将二叉树转化为 链表形势 （下一个节点放在 right子树）
 *
 * （先序遍历形式）
 *
 */
public class Solution114 {

    private TreeNode prv    ;

    public void flatten(TreeNode root) {
        if(root==null)return;

        flatten(root.right);
        flatten(root.left);

        root.right=prv;
        root.left=null;
        prv= root;

    }
}