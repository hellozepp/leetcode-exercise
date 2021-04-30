/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题53（二）：0到n-1中缺失的数字
 * // 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * // 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * // 中，请找出这个数字。
 */
package offer;

public class Java53_02_MissingNumber {
	public int GetMissingNumber(int[] array) {
		if (array == null || array.length <= 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (right + left) / 2;
			if (array[middle] != middle) {
				if (middle == 0 || array[middle - 1] == middle - 1) {
					return middle;
				}
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}
		if (left == array.length) {
			return array.length;
		}
		return -1;
	}
}
