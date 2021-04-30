/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题68：树中两个结点的最低公共祖先
 * // 题目：输入两个树结点，求它们的最低公共祖先。
 */
package offer;

public class Java68_01_CommonParentInTree {
	/** 树是二叉搜索树 */
	//基本思想：二叉搜索树是经过排序的，位于左子树的节点都比父节点小，位于右子树的节点都比父节点大。
	//既然要找最低的公共祖先节点，我们可以从根节点开始进行比较。若当前节点的值比两个节点的值都大，
	//那么最低的祖先节点一定在当前节点的左子树中，则遍历当前节点的左子节点；反之，若当前节点的值比两个
	//节点的值都小，那么最低的祖先节点一定在当前节点的右子树中，则遍历当前节点的右子节点；这样，
	//直到找到一个节点，位于两个节点值的中间，则找到了最低的公共祖先节点。
	public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		if (root.val > p.val && root.val > q.val) {
		    return LowestCommonAncestor(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
		    return LowestCommonAncestor(root.right, p, q);
		}
		else {
			return root;
		}
	}
}