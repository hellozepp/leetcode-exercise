/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题32：分行从上往下打印二叉树
 * // 题目：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
package offer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Java32_02_BranchPrintTree {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){
		    return result;
		}
		//使用队列，先进先出
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		queue.add(pRoot);
		//start记录本层打印了多少个，end记录下一层要打印多少个
		int start = 0, end = 1;
		while(!queue.isEmpty()){
		    TreeNode cur = queue.remove();
		    //添加本行打印的List里
		    tempList.add(cur.val);
		    start++;
		    //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
		    if(cur.left!=null){
		    	queue.add(cur.left);           
		    }
		    if(cur.right!=null){
		    	queue.add(cur.right);
		    }
		    //本层打印完毕
		    if(start == end){
		        end = queue.size();
		        start = 0;
		        result.add(tempList);
		        tempList = new ArrayList<Integer>();
		    }
		}
		return result;
	}
}