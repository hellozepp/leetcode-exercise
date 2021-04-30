/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题21：调整数组顺序使奇数位于偶数前面
 * // 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * // 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
package offer;

public class Java21_ReorderArray {
	public void reOrderArray(int [] array) {
		int length = array.length;
		if (length == 0) {
	        return;
	    }
		int[] des = new int[length];
		MergeSort(array, des, 0, length - 1);
    }
    
	public void MergeSort(int[] array, int[] des, int start, int end) {
	    if (start < end) {
	        int middle = (start + end) / 2;
	        MergeSort(array, des, start, middle);
	        MergeSort(array, des, middle + 1, end);
	        Merge(array, des, start, middle, end);
	    }
	}
    
	public void Merge(int[] array, int[] des, int start, int middle, int end) {
	    int i = start;
	    int j = middle + 1;
	    int k = start;
	    while (i <= middle && array[i] % 2 == 1) {
	        des[k++] = array[i++];
	    }
	    while (j <= end && array[j] % 2 == 1) {
	        des[k++] = array[j++];
	    }
	    while (i <= middle) {
	        des[k++] = array[i++];
	    }
	    while (j <= end) {
	        des[k++] = array[j++];
	    }
	    for (int m = start; m <= end; m++) {
	        array[m] = des[m];
	    }
	}
}