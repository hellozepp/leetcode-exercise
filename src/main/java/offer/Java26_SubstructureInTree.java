/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题26：树的子结构
 * // 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
package offer;

public class Java26_SubstructureInTree {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	    if (root1 == null || root2 == null) {
	        return false;
	    }
	    boolean flag = false;
	    if (root1.val == root2.val) {
	        flag = isSubtree(root1, root2);
	    }
	    if (!flag) {
	        flag = HasSubtree(root1.left, root2);
	    }
	    if (!flag) {
	        flag = HasSubtree(root1.right, root2);
	    }
	    return flag;
	}
	
	private boolean isSubtree(TreeNode root1, TreeNode root2) {
	    if (root2 == null) {
	        return true;
	    }
	    if (root1 == null && root2 != null) {
	        return false;
	    }
	    if (root1.val == root2.val) {
	        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
	    }
	    return false;
	}
}