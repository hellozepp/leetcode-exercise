/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题64：求1+2+…+n
 * // 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * // 等关键字及条件判断语句（A?B:C）。
 */
package offer;

public class Java64_Accumulate {
	public int Sum_Solution(int n) {
		int sum = (int)(Math.pow(n, 2) + n);
		return sum >> 1;
	}
}
