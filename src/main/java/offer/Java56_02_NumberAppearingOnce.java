/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题56（二）：数组中唯一只出现一次的数字
 * // 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * // 找出那个只出现一次的数字。
 */
package offer;

public class Java56_02_NumberAppearingOnce {
    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return res
     */
	public static int find1From3(int[] a) {
		int[] bits = new int[32];
		int len = a.length;
		for (int i = 0; i < len; i++) {
		    for (int j = 0; j < 32; j++) {
		        bits[j] = bits[j] + ((a[i] >>> j) & 1);
		    }
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
		    if (bits[i] % 3 !=0) {
		        res = res | (1 << i);
		    }
		}
		return res;
	}
}