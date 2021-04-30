/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题33：二叉搜索树的后序遍历序列
 * // 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * // 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
package offer;

public class Java33_SquenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if (sequence.length == 0) {
		    return false;
		}
		return isTreeBST(sequence, 0, sequence.length - 1);
	}
    
	public boolean isTreeBST(int[] sequence, int start, int end) {
		if (start > end) {
		    return true;
		}
		//后序遍历最后一个节点为跟节点
		int root = sequence[end];
		
		//在二叉搜索树中左子树节点小于根节点
		int i = 0;
		for (; i < end; i++) {
		    if (sequence[i] > root) {
		        break;
		    }
		}
		
		//在二叉搜索树中右子树节点大于根节点
		int j = i;
		for (; j < end; j++) {
		    if (sequence[j] < root) {
		        return false;
		    }
		}
		
		boolean left = true;
		boolean right = true;
		if (i > start) {
		    left = isTreeBST(sequence, start, i - 1);
		}
		if (i < sequence.length - 1) {
		    right = isTreeBST(sequence, i , end - 1);
		}
		return (left&&right);
	}
}
