package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a111 {
    public static int solution(TreeNode root){
        if (root == null) return 0;
        return 1+Math.min(solution(root.left),solution(root.right));
    }

    public static void main(String[] args) {
         TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
        node.right = new TreeNode(10);
        treeNode.right = node;
        Integer solution = solution(treeNode);
        System.out.println(solution);
    }
}
