package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a112 {
    public boolean pathSum(TreeNode root,int sum){
        if (root==null)return false;
        if (root.left==null&&root.right==null&&root.val-sum==0)return true;
        return pathSum(root.left,sum-root.val)||pathSum(root.right,sum-root.val);
    }
    public boolean pathSum2(TreeNode root,int sum){
      if(root==null)return sum==0;
      if (pathSum2(root.left,sum-root.val))return true;
      if (pathSum2(root.right,sum-root.val))return true;
      return false;
    }
}
