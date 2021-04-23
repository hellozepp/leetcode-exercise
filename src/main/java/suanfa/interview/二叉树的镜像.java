package suanfa.interview;

import static suanfa.interview.对称的二叉树.TreeNode;

/**
 * @Author: zhanglin
 * @Date: 2019/6/20
 * @Time: 11:34 PM
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

}
