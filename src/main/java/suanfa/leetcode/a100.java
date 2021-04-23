package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a100 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        TreeNode treeNode2 = new TreeNode(6);
        treeNode2.left = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        node2.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode2.right = node2;
        boolean solution = solution(treeNode, treeNode2);
        System.out.println(solution);
    }

    private static boolean solution(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return false;
        } else {
            return t1.val == t2.val && solution(t1.left, t2.left) && solution(t1.right, t2.right);
        }


    }
}
