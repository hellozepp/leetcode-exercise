/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题7：重建二叉树
 * // 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * // 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * // 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * // 图2.6所示的二叉树并输出它的头节点。
 */
package offer;

public class Java07_ConstructBinaryTree {
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
		return root;
	}
	
	private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);
		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
				root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
			}
		return root;
	}
	
	//前序遍历
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args){
		int preOrder[] = {1, 2, 4, 7, 3, 5, 6, 8};
		int inOrder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        preOrder(root);
    }
}
