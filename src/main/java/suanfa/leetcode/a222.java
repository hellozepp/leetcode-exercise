package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class a222 {
    public static int solution(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.pop();
            if (peek.right != null)
                stack.push(peek.right);
            if (peek.left != null)
                stack.push(peek.left);
            list.add(peek.val);
        }
        return list.size();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
        node.right = new TreeNode(1);
        treeNode.right = node;
        Integer solution = solution(treeNode);
        System.out.println(solution);
    }
}
