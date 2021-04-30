/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题59（一）：滑动窗口的最大值
 * // 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * // 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * // 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
 */
package offer;
import java.util.ArrayList;
import java.util.Collections;

public class Java59_01_MaxInSlidingWindow {
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
		if (num == null || size < 0) {
		    return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (size == 0) {
		    return list;
		}
		ArrayList<Integer> temp = null;
		int length = num.length;
		if (length < size) {
		    return list;
		}
		else {
		    for (int i = 0; i < length - size + 1; i++) {
		        temp = new ArrayList<Integer>();
		        for (int j = i; j < size + i; j++) {
		            temp.add(num[j]);
		        }
		        Collections.sort(temp);
		        list.add(temp.get(temp.size() - 1));
		    }
		}
		return list;
	}
}