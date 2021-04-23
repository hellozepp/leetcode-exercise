package suanfa.playWithAlgorithmsData.tree.BinarySearchTree;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static List levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);//弹出队首
            if (poll.left != null) {
                queue.offer(poll.left);//添加队尾
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }

    public static int levelOrderGetLevel1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(levelOrderGetLevel1(root.left), levelOrderGetLevel1(root.right));
    }

    public static int levelOrderGetSmallLevel1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null || root.left != null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(levelOrderGetSmallLevel1(root.left), levelOrderGetSmallLevel1(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
//        List<Integer> solution = levelOrderGetLevel(treeNode);
        Integer solution = levelOrderGetSmallLevel1(treeNode);
        System.out.println(solution);
    }
}
