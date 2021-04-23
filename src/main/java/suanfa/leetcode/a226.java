package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a226 {
    public static TreeNode solution(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode right = solution(root.right);
        TreeNode left = solution(root.left);
        root.left =right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
         TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        TreeNode solution = solution(treeNode);
        solution.inOrder(solution);
    }
}
