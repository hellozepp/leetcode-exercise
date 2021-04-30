/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题68：树中两个结点的最低公共祖先
 * // 题目：输入两个树结点，求它们的最低公共祖先。
 */
package offer;
import java.util.ArrayList;
import java.util.List;
public class Java68_02_CommonParentInTree {
	/** 树不是二叉树，但是有指向父节点的引用，转换为求两个链表的第一个公共结点 */
	/** 树不是二叉树，也没有指向父节点的引用 */
	//基本思想：需要保存由root节点到p和q节点的路径，并且将路径存入list中，将问题转化为
	//求两个list集合的最后一个共同元素。
	public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null) {
			return null;
		}
		List<TreeNode> pathp = new ArrayList<>();  
		List<TreeNode> pathq = new ArrayList<>();  
		pathp.add(root);  
		pathq.add(root);  
		  
		getPath(root, p, pathp);  
		getPath(root, q, pathq);  
		  
		TreeNode lca = null;  
		for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {  
		    if(pathp.get(i) == pathq.get(i)) {
		    	lca = pathp.get(i);  
		    }
		    else {
		    	break; 
		    }
		}  
		return lca;  
	}  
      
	private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {  
		if (root == n) {
        	return true;
        }
		if (root.left != null) {  
		    path.add(root.left);  
		    if (getPath(root.left, n, path)) {
		    	return true;  
		    }
		    path.remove(path.size() - 1);  
		}
		  
		if (root.right != null) {  
		    path.add(root.right);  
		    if (getPath(root.right, n, path)) {
		    	return true;  
		    }
		    path.remove(path.size()-1);  
		}
		return false;  
    }
}