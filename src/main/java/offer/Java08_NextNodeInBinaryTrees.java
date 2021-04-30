/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题8：二叉树的下一个结点
 * // 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * // 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
package offer;

public class Java08_NextNodeInBinaryTrees {
	public TreeLinkNode GetNext(TreeLinkNode pNode)
	{
	    TreeLinkNode curNode = null;
	    //第一步：判断是否有右孩子
	    if(pNode.right != null){
	        curNode = pNode.right;
	        while(curNode.left != null) {
	            curNode = curNode.left;
	        }
	        return curNode;
	    }
	    //第二步：判断是否是其父节点的左孩子
	    if(pNode.next == null) {
	        return null;
	    }
	    if(pNode == pNode.next.left){
	        return pNode.next;
	    }
	    //第三步：向上找其父节点，直到父节点是其父节点的父节点的左孩子
	    curNode = pNode.next;
	    while(curNode.next != null){
	        if(curNode == curNode.next.left){
	            return curNode.next;
	        }
	        //继续向上找父节点
	            curNode = curNode.next;
	        }
	        return null;
	    }
	}
