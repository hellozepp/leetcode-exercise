/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题28：对称的二叉树
 * // 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * // 它的镜像一样，那么它是对称的。
 */
package offer;

public class Java28_SymmetricalBinaryTree {
	public boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetrical(pRoot, pRoot);
	}
	
	//定义两个遍历，一个前序遍历，一个是和前序遍历相反的，先右后左的遍历
	public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
	    if (pRoot1 == null && pRoot2 == null) {
	        return true;
	    }
	    if (pRoot1 == null || pRoot2 == null) {
	        return false;
	    }
	    if (pRoot1.val != pRoot2.val) {
	        return false;
	    }
	    return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
	}
}