/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题34：二叉树中和为某一值的路径
 * // 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * // 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
package offer;
import java.util.ArrayList;
import java.util.Stack;

public class Java34_PathInTree {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
		    return pathList;
		}
		Stack<Integer> stackPath = new Stack<Integer>(); 
		FindPath(root, target, stackPath, pathList);
		return pathList;
	}
    
	public void FindPath(TreeNode root, int target, Stack<Integer> stackPath, ArrayList<ArrayList<Integer>> pathList) {
		if (root == null) {
		    return;
		}
		//如果是叶子节点，判断是否是目标值
		if (root.left == null && root.right == null) {
		    if (root.val == target) {
		        ArrayList<Integer> list = new ArrayList<Integer>();
		        for (int i: stackPath) {
		            list.add(new Integer(i));
		        }
		        list.add(new Integer(root.val));
		        pathList.add(list);
		    }
		}
		//不是叶子节点就遍历其他子节点
		else {
		    stackPath.push(new Integer(root.val));
		    //是按照前序遍历的方式查找路径，如果向上退出到父节点时，要回到target值，而不是target-root.val
		    FindPath(root.left, target-root.val, stackPath, pathList);
		    FindPath(root.right, target-root.val, stackPath, pathList);
		    stackPath.pop();
		}
	}
}