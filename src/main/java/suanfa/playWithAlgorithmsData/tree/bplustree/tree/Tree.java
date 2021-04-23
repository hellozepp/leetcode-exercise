package suanfa.playWithAlgorithmsData.tree.bplustree.tree;

public class Tree {
    //root节点
    protected Node root;

    //算法中那个m
    protected int m;

    //子树链表的头指针
    protected Node head;

    public Tree(int m) {
        if (m < 3) {
            System.out.print("定义错误！m最小为3");
            System.exit(0);
        }
        this.m = m;
        root = new Node(true, true);
        head = root;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
}
