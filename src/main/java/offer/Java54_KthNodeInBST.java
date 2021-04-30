/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题54：二叉搜索树的第k个结点
 * // 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 */
package offer;

public class Java54_KthNodeInBST {
	/** 中序遍历就是二叉搜索树的排序 */
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0){
		    return null;
		}
		TreeNode[] result = new TreeNode[1];
		KthNode(pRoot, k, new int[1], result);
		return result[0];
	}
    
    public void KthNode(TreeNode pRoot, int k, int[] count, TreeNode[] result){
    	if (result[0] != null || pRoot == null) {
    		return;
    	}
    	KthNode(pRoot.left, k, count, result);
    	count[0]++;
    	if (count[0] == k) {
    		result[0] = pRoot;
    	}
    	KthNode(pRoot.right, k, count, result);
    }
}