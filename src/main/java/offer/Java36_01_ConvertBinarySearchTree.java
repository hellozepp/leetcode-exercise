/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题36：二叉搜索树与双向链表
 * // 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * // 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
package offer;

public class Java36_01_ConvertBinarySearchTree {
	/** 递归中序遍历 */
	TreeNode head = null;
	//双向链表的头结点
	TreeNode realHead = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null) return null;
		Convert(pRootOfTree.left);
		if (head == null) {
		    head = pRootOfTree;
		    realHead = pRootOfTree;
		} else {
		    head.right = pRootOfTree;
		    pRootOfTree.left = head;
		    head = pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return realHead;
	}
}
