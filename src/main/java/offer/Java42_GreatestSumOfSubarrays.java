/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题42：连续子数组的最大和
 * // 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * // 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
package offer;

public class Java42_GreatestSumOfSubarrays {
	/**
	*基本思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
	*整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。若和大于maxSum,则用maxSum记录下来。
	*用total记录累积值，用maxSum记录和最大。
	*/
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0 || array == null) {
			return 0;
		}
		else {
			int total = array[0];
			int maxSum = array[0];
			for (int i = 1; i < array.length; i++) {
				//刚开始如果total<0，说明从开始位置到i-1位置到元素不可能属于这个连续子数组的范围
				if (total >= 0) {
				    total += array[i];
				}
				else {
				    total = array[i];
				}
				if (total > maxSum) {
				    maxSum = total;
				}
		    }
		    return maxSum;
	    }
	}
}