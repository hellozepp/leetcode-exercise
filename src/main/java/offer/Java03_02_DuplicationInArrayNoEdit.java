/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题3（二）：不修改数组找出重复的数字
 * // 题目：在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至
 * // 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * // 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * // 输出是重复的数字2或者3。
 */
package offer;

public class Java03_02_DuplicationInArrayNoEdit {
	public int getDuplication(int[] numbers, int length){
		if (numbers == null || length <= 0)
			return -1;
		//条件判断，保证数组中的元素值在1～n的范围内
		for (int i = 0; i < length; i++)
			if (numbers[i] < 1 || numbers[i] > length-1)
				return -1;
        
		int start = 1;
		int end = length-1;
		while (start <= end){
			int middle = (start + end) / 2;
			int count = 0;
			//对范围内的元素个数进行计数
			for (int i = 0; i < length; i++) {
				if(numbers[i] <= middle && numbers[i] >= start)
					count++;
            }
			if (start == end) {
				if (count > 1)
					return start;
				else 
					break;
            }
			// 根据检测情况调整会出现重复的整数范围
			if (count > middle - start + 1)
				end = middle;
			else
				start = middle + 1;
        }
		return -1;
    }
}