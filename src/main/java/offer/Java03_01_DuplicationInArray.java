/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题3（一）：找出数组中重复的数字
 * // 题目：在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * // 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * // 那么对应的输出是重复的数字2或者3。
 */
package offer;

public class Java03_01_DuplicationInArray {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
        	return false;
        }
        //条件判断，保证数组中的元素值在0～n-1的范围内
        for (int i = 0; i < length; i++) {
        	if (numbers[i] < 0 || numbers[i] > length - 1)
        		return false;
        }
        for (int i = 0; i < length; i++) {
        	while (numbers[i] != i) {
        		if (numbers[numbers[i]] == numbers[i]) {
        			duplication[0] = numbers[i];
        			return true;
        		}
        		int temp = numbers[i];
        		numbers[i] = numbers[temp];
        		numbers[temp] = temp;
        	}
        }
        return false;
    }
}
