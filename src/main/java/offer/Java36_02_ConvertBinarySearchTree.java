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
import java.util.Stack;

public class Java36_02_ConvertBinarySearchTree {
	/** 非递归 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) {
			return pRootOfTree;
			}
		TreeNode list = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(pRootOfTree != null || !stack.isEmpty()){
			if(pRootOfTree != null) {
				stack.push(pRootOfTree);
				pRootOfTree = pRootOfTree.right;
				} 
			else {
				pRootOfTree = stack.pop();
				if(list == null) {
					list = pRootOfTree;
					}
				else {
					list.left = pRootOfTree;
					pRootOfTree.right = list;
					list = pRootOfTree;
					}
				pRootOfTree = pRootOfTree.left;
				}
			}
		return list;
		}
	}