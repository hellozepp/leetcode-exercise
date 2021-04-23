package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回先序遍历
 * <p>
 * 使用 迭代方式
 * <p>
 * 难度2星
 */
public class Solution144 {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node != null) {
                if (node.right != null)
                    queue.push(node.right);
                if (node.left != null)
                    queue.push(node.left);
                result.add(node.val);
            }
        }
        return result;
    }


    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        List list = new ArrayList<>();

        traver(list, root);

        return list;

    }

    private void traver(List list, TreeNode root) {

        if (root == null) return;


        list.add(root.val);

        traver(list, root.left);
        traver(list, root.right);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        List<Integer> solution = new Solution144().preorderTraversal(treeNode);
        System.out.println(solution);//[3, 7, 8, 6]
    }
}