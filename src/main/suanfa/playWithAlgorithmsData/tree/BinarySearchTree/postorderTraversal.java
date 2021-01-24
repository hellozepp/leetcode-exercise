package suanfa.playWithAlgorithmsData.tree.BinarySearchTree;

import javafx.util.Pair;
import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.*;

public class postorderTraversal {//后序 栈的方法倒着写

    public static List<Integer> postorderTraversal(TreeNode root) {
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

    private static class Command {
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

    /**
     * 队列的方法 倒着写
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
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
     * 6
     * /\
     * 3 8
     * /
     * 7
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        List<Integer> solution = postorderTraversal(treeNode);
        System.out.println(solution);//[3, 7, 8, 6]
        System.out.println(inorderTraversal(treeNode));//[3, 6, 7, 8]
        System.out.println(preorderTraversal(treeNode));//[6, 3, 8, 7] 先跟,等于层序
    }
}
