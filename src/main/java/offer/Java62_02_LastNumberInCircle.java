/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题62：圆圈中最后剩下的数字
 * // 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * // 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
package offer;
import java.util.ArrayList;

public class Java62_02_LastNumberInCircle {
	/** 方法二：链表,O(N) */
	public int LastRemaining_Solution(int n, int m) {
		if (m == 0 || n == 0) {
		    return -1;
		}
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
		    data.add(i);
		}
		int index = -1;
		while (data.size() > 1) {
			//重点是此步
		    index = (index + m) % data.size();
		    data.remove(index);
		    index--;
		}
		return data.get(0);
	}
}