/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题37：序列化二叉树
 * // 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
package offer;

public class Java37_SerializeBinaryTrees {
	public int index = -1;
	/** 序列化 */
	String Serialize(TreeNode root) {
		StringBuffer stringBuffer = new StringBuffer();
		if (root == null) {
		    stringBuffer.append("#,");
		    return stringBuffer.toString();
		}
		stringBuffer.append(root.val + ",");
		    stringBuffer.append(Serialize(root.left));
		    stringBuffer.append(Serialize(root.right));
		    return stringBuffer.toString();
	  }
    
	/** 反序列化 */
	TreeNode Deserialize(String str) {
		//数组指针，每次下移一位
		index++;
		int length = str.length();
		if (index >= length) {
		    return null;
		}
		String[] stringArr = str.split(",");
		TreeNode node = null;
		if (!stringArr[index].equals("#")) {
		        node = new TreeNode(Integer.valueOf(stringArr[index]));
		        node.left = Deserialize(str);
		        node.right = Deserialize(str);
		    }
		    return node;
	  }
}