package suanfa.playWithAlgorithmsData.tree.BinarySearchTree;

import javafx.util.Pair;
import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.*;

/**
 *     a
 *    /  \
 *   b    c
 *  / \   /
 * d   e  f
 *  pre: ABDECF
 *  in: DBEAFC
 *  post: DEBFCA
 */
public class postorderTraversal {//后序 栈的方法倒着写

    public static List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<Pair<TreeNode, Boolean>>();
        stack.push(new Pair<TreeNode, Boolean>(root, false));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pop = stack.pop();
            if (pop.getValue()) {
                res.add(pop.getKey().val);
            } else {
                stack.push(new Pair<TreeNode, Boolean>(pop.getKey(), true));
                if (null != pop.getKey().right) {
                    stack.push(new Pair<TreeNode, Boolean>(pop.getKey().right, false));
                }
                if (null != pop.getKey().left) {
                    stack.push(new Pair<TreeNode, Boolean>(pop.getKey().left, false));
                }

            }
        }
        return res;
    }

     static class Command {
        String s;   // go, print
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    // 倒着写,右根左
    public static List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                stack.push(new Command("print", command.node));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return res;
    }

    // 倒着写,右左根
    public static List<Integer> preOrderTraversal1(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
                stack.push(new Command("print", command.node));

            }
        }
        return res;
    }

    /**
     * 队列的方法 倒着写 
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node != null) {
                queue.push(node.right);
                queue.push(node.left);
                result.add(node.val);
            }
        }
        return result;
    }

    /**
     *  非递归版本层序遍历，即 bfs
     * @param root
     * @return
     */
    public static List<Integer> levelOrder(TreeNode root) {
        // 我们使用LinkedList来作为我们的队列
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return result;
    }

    /**
     * 6
     * /\
     * 3 8
     * /\  /
     * 7 9 10
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(9);
        treeNode.right = node;
        node.left = new TreeNode(10);
        System.out.println("postOrderTraversal:" + postOrderTraversal(treeNode));//[7, 9, 3, 10, 8, 6]
        System.out.println("inorderTraversal:" + inorderTraversal(treeNode));//[7, 3, 9, 6, 10, 8]
        System.out.println("preOrderTraversal:" + preOrderTraversal(treeNode));//[6, 3, 7, 9, 8, 10]
        System.out.println("preOrderTraversal1:" + preOrderTraversal1(treeNode));//[6, 3, 7, 9, 8, 10]
        System.out.println("levelOrder:" + levelOrder(treeNode));//[6, 3, 8, 7, 9, 10]
    }
}
