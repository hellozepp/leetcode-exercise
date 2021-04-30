/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题27：二叉树的镜像
 * // 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
package offer;

public class Java27_MirrorOfBinaryTree {
	public void Mirror(TreeNode root) {
	    if (root == null) {
	        return;
	    }
	    if (root.left != null || root.right != null) {
	        //创建临时节点，交换左右节点
	        TreeNode tempNode = null;
	        tempNode = root.left;
	        root.left = root.right;
	        root.right = tempNode;
	        Mirror(root.left);
	        Mirror(root.right);
	    }
	}
}