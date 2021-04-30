/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题32：不分行从上往下打印二叉树
 * // 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
package offer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Java32_01_PrintTreeFromTopToBottom {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
		    return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
		    TreeNode treeNode = queue.poll();
		    if (treeNode.left != null) {
		        queue.offer(treeNode.left);
		    }
		    if (treeNode.right != null) {
		        queue.offer(treeNode.right);
		    }
		    list.add(treeNode.val);
		}
		return list;
	}
}
