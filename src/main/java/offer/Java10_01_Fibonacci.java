/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题10（一）：斐波那契数列
 * // 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
package offer;

public class Java10_01_Fibonacci {
	//解法1：用递归解决，存在很严重的效率问题，做了很多次重复的计算
	public int Fib1(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return Fib1(n - 1) + Fib1(n - 2);
		}
	}
	
	//解法2:时间复杂度为O(n)，从下向上计算，保存已计算过的数值，避免重复计算
	public int Fib2(int n) {
		long FibOne = 0;
		long FibTwo = 1;
		long FibN = 0;
		int result[] = {0, 1};
		if (n < 2) {
			return result[n];
		}
		else {
			for (int i = 2; i <= n; i++) {
				FibN = FibTwo + FibOne;
				FibOne = FibTwo;
				FibTwo = FibN;
			}
		}
		return (int)FibN;
	}
}
