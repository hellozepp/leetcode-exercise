package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a257 {
    public static List<String> binaryTreePath(TreeNode root){
       if (root==null)return new ArrayList<>();
       List<String > res = new ArrayList<>();
       if (root.left==null&&root.right==null){
           res.add(root.val+"");
            return res;
       }
       List<String> lPaths = binaryTreePath(root.left);
        for (String lPath : lPaths) {
            res.add(root.val+"->"+lPath);
        }
       List<String> rPaths = binaryTreePath(root.right);
        for (String r : rPaths) {
            res.add(root.val+"->"+r);
        }
        return res;
    }
    public static void main(String[] args) {
           TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
//        List<Integer> solution = levelOrderGetLevel(treeNode);
        System.out.println(binaryTreePath(treeNode));
    }
}
