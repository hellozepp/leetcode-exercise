/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题40：最小的k个数
 * // 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * // 这8个数字，则最小的4个数字是1、2、3、4。
 */
package offer;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;

public class Java40_02_KLeastNumbers {
  /** 基于堆或者红黑树的解法 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> leastNum = new ArrayList<Integer>();
		if (input == null || input.length < 1 || k < 1 || k > input.length) {
			return leastNum;
		}
		TreeSet<Integer> kSet = new TreeSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (kSet.size() < k) {
				kSet.add(input[i]);
			}
			else {
				if (input[i] < kSet.last()) {
					kSet.remove(kSet.last());
					kSet.add(input[i]);
				}
			}
		}
		Iterator<Integer> iterator = kSet.iterator();
		while (iterator.hasNext()) {
			leastNum.add(iterator.next());
		}
		return leastNum;
	}
}
