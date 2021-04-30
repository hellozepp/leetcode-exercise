/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题55（二）：平衡二叉树
 * // 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
 * // 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
package offer;

public class Java55_02_BalancedBinaryTree {
	/** 基本思想：后序遍历整棵二叉树 */
	//在遍历某节点的左、右子节点之后，可以根据它左、右子节点的深度判断它是不是平衡的，并得到当前节点的深度。
	//当最后遍历树的跟节点的时候，也就判断了整棵二叉树是不是平衡二叉树。
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		}
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}
	 
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	 
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}
}