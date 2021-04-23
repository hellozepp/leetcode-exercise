package suanfa.playWithAlgorithmsData.tree;

import java.util.*;

/**
 *
 * JAVA实现二叉树的先序、中序、后序、层序遍历
 * 递归和非递归版本 
 *
 */

public class Node {
    public int value;
    public Node left = null;
    public Node right = null;

    public Node(int v) {
        this.value = v;
    }

}

class BinaryTreeTraversal {
    /**
     * @param root 树根节点
     * 递归先序遍历
     */
    public static void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    /**
     * @param root 树根节点
     * 递归中序遍历
     */
    public static void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.value);
            inOrderRec(root.right);
        }
    }

    /**
     * @param root 树根节点
     * 递归后序遍历
     */
    public static void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.value);
        }
    }

    /**
     *
     * @param root 树根节点 
     * 利用栈实现循环先序遍历二叉树 
     * 这种实现类似于图的深度优先遍历（DFS） 
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。 
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用 
     */
    public static void preOrderStack_1(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.pop();
            System.out.println(temp.value);
            if (temp.right != null) s.push(temp.right);
            if (temp.left != null) s.push(temp.left);
        }
    }

    /**
     *  先序遍历
     * @param root 树的根节点 
     * 利用栈模拟递归过程实现循环先序遍历二叉树 
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树 
     */
    public static void preOrderStack_2(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                System.out.println(root.value);
                s.push(root);//先访问再入栈  
                root = root.left;
            }
            root = s.pop();
            root = root.right;//如果是null，出栈并处理右子树
        }
    }

    /**
     *  中跟遍历/中序遍历
     * @param root 树根节点
     * 利用栈模拟递归过程实现循环中序遍历二叉树 
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。 
     */
    public static void inOrderStack(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);//先访问再入栈  
                root = root.left;
            }
            root = s.pop();
            System.out.println(root.value);
            root = root.right;//如果是null，出栈并处理右子树
        }
    }

    /**
     *  后序遍历非递归的算法
     * @param root 树根节点
     * 后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，
     *             所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现
     */
    public static void postOrderStack(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        Map<Node, Boolean> map = new HashMap<Node, Boolean>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.peek();
            if (temp.left != null && !map.containsKey(temp.left)) {
                temp = temp.left;
                while (temp != null) {
                    if (map.containsKey(temp)) break;
                    else s.push(temp);
                    temp = temp.left;
                }
                continue;
            }
            if (temp.right != null && !map.containsKey(temp.right)) {
                s.push(temp.right);
                continue;
            }
            Node t = s.pop();
            map.put(t, true);
            System.out.println(t.value);
        }
    }

    /**
     * 非递归实现后序遍历/后根遍历
     *
     */
    public static void nocruPost(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();
        Node last = root;
        while (root != null) {
            //一直往左走
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            //当前栈顶结点没有又孩子                  右节点等于根节点
            while (root != null && (root.right == null || root.right == last)) {
                System.out.println(root.value);//
                last = root;
                if (stack.isEmpty()) return;//结束
                root = stack.pop();
            }
            //当前栈顶结点的左孩子访问完毕，往其又孩子看
            stack.push(root);
            root = root.right;
        }
    }

    /**
     *
     * @param root 树根节点 
     * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列
     */
    public static void levelTravel(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println(temp.value);
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    public static final int getTreeDepth(final Node node) {
        if (node == null) return 0;
        final int l, r;
        return (l = getTreeDepth(node.left)) > (r = getTreeDepth(node.right)) ? l + 1 : r + 1;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.left.right = new Node(5);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println("先序1");
        preOrderRec(node);
        System.out.println("中序1");
        inOrderRec(node);
        System.out.println("中序2");
        inOrderStack(node);
        System.out.println("后序1");
        postOrderRec(node);
        System.out.println("后序2");
        nocruPost(node);
        System.out.println("getTreeDepth:" + getTreeDepth(node));
    }
}
