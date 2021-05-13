package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树的层次遍历
 * <p>
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 难度1星
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        track(root, list, 0);
        return list;
    }

    private void track(TreeNode root, List<List<Integer>> list, int h) {

        if (root == null) return;

        if (h >= list.size()) {
            list.add(h, new ArrayList<>());
        }
        list.get(h).add(root.val);
        track(root.left, list, h + 1);
        track(root.right, list, h + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new Solution102().levelOrder(treeNode));
    }
}