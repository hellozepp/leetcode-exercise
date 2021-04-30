/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题57（二）：为s的连续正数序列
 * // 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * // 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * // 4～6和7～8。
 */
package offer;
import java.util.ArrayList;

public class Java57_02_ContinuousSquenceWithSum {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return list;
		}
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while (small < middle) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (curSum == sum) {
				for (int i = small; i <= big; i++) {
					temp.add(i);
				}
				list.add(temp);
			}
			while (curSum > sum && small < middle) {
				curSum -= small;
				small++;
				if (curSum == sum) {
					for (int i = small; i <= big; i++) {
						temp.add(i);
					}
					list.add(temp);
				}
			}
			big++;
			curSum += big;
		}
		return list;
	}
}
