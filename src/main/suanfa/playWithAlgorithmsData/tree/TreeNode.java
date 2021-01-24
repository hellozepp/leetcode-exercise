package suanfa.playWithAlgorithmsData.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){this.val = val;}
    public void insert(int val){
        TreeNode root = this;
        root = insertPriv(root,val);
    }

    private TreeNode insertPriv(TreeNode root, int val) {
        if (root==null){
            root =  new TreeNode(val);
        }
        if (root.val>val){
            root.left =  insertPriv(root.left,val);
        }
        if (root.val<val){
            root.right =  insertPriv(root.right,val);
        }
        return root;
    }
    public void inOrder(TreeNode root){
        if (root!=null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }
    public void preOrder(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            inOrder(root.left);
            inOrder(root.right);
        }
    }
    public void postOrder(TreeNode root){
        if (root!=null){
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.val);
        }
    }
}
