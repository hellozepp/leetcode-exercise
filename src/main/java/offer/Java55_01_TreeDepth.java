/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题55（一）：二叉树的深度
 * // 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * // 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
package offer;

public class Java55_01_TreeDepth {
	public int TreeDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		int nLelt = TreeDepth(root.left);
		int nRight = TreeDepth(root.right);
		return nLelt > nRight ? (nLelt + 1): (nRight + 1);
	}
}