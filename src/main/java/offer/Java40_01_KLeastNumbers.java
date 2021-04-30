/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题40：最小的k个数
 * // 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * // 这8个数字，则最小的4个数字是1、2、3、4。
 */
package offer;
import java.util.ArrayList;

public class Java40_01_KLeastNumbers {
	/** 基于Partition函数的解法 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		if (input == null || input.length < k || k <= 0) {
		    return aList;
		}
		int low = 0;
		int high = input.length - 1;
		int index = Partition(input, k, low, high);
		while (index != k - 1) {
		    if (index > k - 1) {
		        high = index - 1;
		        index = Partition(input, k, low, high);
		    }
		    else {
		        low = index + 1;
		        index = Partition(input, k, low, high);
		    }
		}
		for (int i = 0; i < k; i++) {
		    aList.add(input[i]);
		}
		return aList;
	}
	
	public int Partition(int[] input, int k, int low, int high) {
		int pivotkey = input[k - 1];
		swap(input, k - 1, low);
		while (low < high) {
		    while (low < high && input[high] >= pivotkey) {
		        high--;
		    }
		    swap(input, low, high);
		    while (low < high && input[low] <= pivotkey) {
		        low++;
		    }
		    swap(input, low, high);
		}
		return low;
	}
	
	private void swap(int[] input, int low, int high) {
		int temp = input[low];
		input[low] = input[high];
		input[high] = temp;
	}
}
