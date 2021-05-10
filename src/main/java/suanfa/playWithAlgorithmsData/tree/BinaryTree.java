package suanfa.playWithAlgorithmsData.tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class BinaryTree {
    private Scanner in = new Scanner(System.in);

    void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void preOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) {
                System.out.print(n.data + " ");
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                n = stack.peek();
                stack.pop();
                n = n.right;
            }
        }
    }

    void inOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                n = stack.peek();
                System.out.print(n.data + " ");
                stack.pop();
                n = n.right;
            }
        }
    }

    void postOrder3(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur;//��ǰ�ڵ�
        Node prev = null;//ǰһ�η��ʵĽڵ�
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null)
                    || (prev != null && (prev == cur.left ||
                    prev == cur.right
            )
            )
            ) {
                System.out.print(cur.data + " ");
                stack.pop();
                prev = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    void bfs(Node root) {
        if (root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        print(root);
        while (!list.isEmpty()) {
            Node n = list.remove();
            if (n.left != null) {
                print(n.left);
                list.add(n.left);
            }
            if (n.right != null) {
                print(n.right);
                list.add(n.right);
            }
        }
    }

    /**
     * dfs 栈版本, 相当于先根遍历，栈倒着写
     * @param root
     */
    void dfsWithStack(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            System.out.print(r.data + " ");
            if (r.right != null) {
                stack.push(r.right);
            }
            if (r.left != null) {
                stack.push(r.left);
            }
        }
    }

    /**
     * dfs 递归版本
     * @param root
     */
    void dfs(Node root) {
        if (root == null)
            return;
        print(root);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    private void print(Node root) {
        System.out.print(root.data + " ");
    }

    Node build(Node root) {
        if (root == null)
            root = new Node();
        if ((root.data = in.nextInt()) == -1)
            return null;
        root.left = build(root.left);
        root.right = build(root.right);
        return root;
    }

    class Node {
        Node left;
        Node right;
        int data;

        public Node() {
        }

        public Node(int d) {
            left = null;
            right = null;
            data = d;
        }
    }

    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
    private static boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        Long begintime = System.nanoTime();
        boolean res = IsBalanced_Solution(node1);
        Long endtime = System.nanoTime();
        System.out.println("该二叉树是否为平衡二叉树：" + res + ",运行时间：" + (endtime - begintime) + "ns");

    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public static int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;

    }

}