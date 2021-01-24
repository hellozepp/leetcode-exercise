package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a129 {
    public static int solution(TreeNode root) {
        if (root == null) return 0;
        int res =0;
        for (String s : getpath(root)) {
            res+=Integer.parseInt(s);
        }
        return res;
    }

    private static List<String> getpath(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> l = getpath(root.left);
        for (String s : l) {
            list.add( root.val + s);
        }
        List<String> r = getpath(root.right);
        for (String s : r) {
            list.add( root.val + s);
        }
        return list;
    }

    public static void main(String[] args) {
             TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
//        List<Integer> solution = levelOrderGetLevel(treeNode);
        System.out.println(solution(treeNode));
    }
}
