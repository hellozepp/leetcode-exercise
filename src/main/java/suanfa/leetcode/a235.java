package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

public class a235 {
    /**
     *
     * 给定一棵二分搜索树和两个节点，寻找这两个节点的最近公共祖先。
     *
     * @param root*/
    public static Integer solution(TreeNode root,TreeNode p,TreeNode q){
           if(root.val>p.val &&root.val>q.val)return  solution(root.left,p,q);
        else if(root.val<p.val&&root.val<q.val)return  solution(root.right,p,q);
        else return root.val;
    }
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(6);
        bst.insert(2);
        bst.insert(8);
        bst.insert(0);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);
        bst.insert(3);
        bst.insert(5);
        bst.inOrder(bst);
        System.out.println(solution(bst,new TreeNode(2),new TreeNode(4)));;//2
    }
}
