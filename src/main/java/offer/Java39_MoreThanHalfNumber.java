/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题39：数组中出现次数超过一半的数字
 * // 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * // 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * // 出现了5次，超过数组长度的一半，因此输出2。
 */
package offer;

public class Java39_MoreThanHalfNumber {
	public int MoreThanHalfNum_Solution(int [] array) {
		if (array == null || array.length <= 0) {
		    return 0;
		}
		int result = array[0];
		int count = 1;
		for (int i = 1; i < array.length; i++) {
		    if (array[i] == result) {
		        count++;
		    }
		    else if (count > 0) {
		        count--;
		    }
		    else if (count == 0){
		        result = array[i];
		        count = 1;
		    }
		}
		//验证
		count = 0;
		for (int i = 0; i < array.length; i++) {
		    if (array[i] == result) {
		        count++;
		    }
		}
		return count > array.length / 2 ? result : 0;
	}
}