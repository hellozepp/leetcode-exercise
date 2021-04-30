/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题32：之字形打印二叉树
 * // 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照
 * // 从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
package offer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Java32_03_ZigzagPrintTree {
	/** 分行打印的代码，添加一段判断用以倒叙输出即可 */
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){
		    return result;
		}
		boolean leftToRight = true;
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
		        if (!leftToRight) {
		        	result.add(reverse(tempList));
		        }
		        else {
		        	result.add(tempList);
		        }
		        leftToRight = !leftToRight;
		        tempList = new ArrayList<Integer>();
		    }
		}
		return result;
	}
	
	public ArrayList reverse(ArrayList<Integer> originList) {
		int length = originList.size();
		ArrayList<Integer> reverseList = new ArrayList<Integer>();
		for (int i = length - 1; i >= 0; i--) {
			reverseList.add(originList.get(i));
		}
		return reverseList;
	}
}