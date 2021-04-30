/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题53（一）：数字在排序数组中出现的次数
 * // 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * // 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
package offer;

public class Java53_01_NumberOfK {
	public int GetNumberOfK(int[] array, int k) {
		int num = 0;
		if (array != null && array.length > 0) {
			int firstKIndex = getFirstK(array, k, 0, array.length - 1);
			int lastKIndex = getLastK(array, k, 0, array.length - 1);
			if (firstKIndex > -1 && lastKIndex > -1)
				num = lastKIndex - firstKIndex + 1;
		}
		return num;
	}

    /*
    * 找到第一个k出现的数字的下标
    */
	public int getFirstK(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middleIndex = start + (end - start) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			//判断是不是第一个k，前一个不等于k，就是第一个k
			if (middleIndex > 0 && array[middleIndex - 1] != k || middleIndex == 0) {
				return middleIndex;
			} 
			else {
				end = middleIndex - 1;
			}
		} 
		else if (middleData > k) {
			end = middleIndex - 1;
		} 
		else {
			start = middleIndex + 1;
		}
		return getFirstK(array, k, start, end);
	}

    /*
    * 找到最后一个k出现的数字的下标
    */
	public int getLastK(int array[], int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			//判断是不是最后一个k，后一个不等于k，就是最后一个k
			if (middleIndex < array.length - 1 && array[middleIndex + 1] != k || middleIndex == array.length - 1) {
				return middleIndex;
			}
			else {
				start = middleIndex + 1;
			}
		} 
		else if (middleData < k) {
			start = middleIndex + 1;
		} 
		else {
			end = middleIndex - 1;
		}
		return getLastK(array, k, start, end);
	}
}