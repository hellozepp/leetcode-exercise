package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a98 {
     private static boolean solution(TreeNode node) {
         if (node.left==null&&node.right==null){
             return true;
         }else if(node.left==null){
             return node.val<node.right.val;
         }else if (node.right==null){
             return node.val>node.left.val;
         }
         return (node.val > node.left.val && solution(node.left)) && (node.val < node.right.val && solution(node.right));
    }
    public static boolean solution2(TreeNode root){
         if(root==null){
             return true;
         }
         return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private static boolean helper(TreeNode root,int min, int max){
         if (root==null){
             return true;
         }
         if (root.val<=min||root.val>=max){
             return false;
         }
         boolean left = helper(root.left,min,root.val);
         boolean right = helper(root.right,root.val,max);
         return left&&right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node =  new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        boolean a=solution2(treeNode);
        System.out.println(a);
    }


}
