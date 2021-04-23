package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a101 {
    public static Boolean solution(TreeNode root){
        if (root==null)return true;
        return isSameTree(root.left,root.right);
    }

    private static Boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1==null &&  t2 ==null){
            return true;
        }
        if (t1==null ||t2==null)return false;
        if (t1.val ==t2.val) {
            return isSameTree(t1.left,t2.right) && isSameTree(t1.right,t2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1<<5);
    }
}
