package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a110 {
    public boolean balanceBinaryTree(TreeNode root){
        if (helper(root)==-1){
            return false;
        }else {return true;}
    }

    private int helper(TreeNode root) {
        if (root==null){
            return 0;
        }
        int i = helper(root.left);
        if (i==-1){
            return -1;
        }
        int j = helper(root.right);
        if (j==-1){
            return -1;
        }
        if (i-j>1||i-j<-1){
            return -1;
        }
        return Math.max(i,j)+1;
    }

    public static void main(String[] args) {

    }
}
