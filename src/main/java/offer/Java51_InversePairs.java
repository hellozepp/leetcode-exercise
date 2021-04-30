/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题51：数组中的逆序对
 * // 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * // 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
package offer;

public class Java51_InversePairs {
	/** 归并排序的思想 */
	public int InversePairs(int [] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		int pairsNum = mergeSort(array, 0, array.length-1);
		return pairsNum;
	}
        
	public int mergeSort(int[] array, int start, int end) {
		if (start == end){
			return 0;
		}
		int mid = (start + end) / 2;
		int leftNum = mergeSort(array, start, mid);
		int rightNum = mergeSort(array, mid+1, end);
		return (Sort(array, start, mid, end) + leftNum + rightNum) % 1000000007;
	}
        
	public int Sort(int[] array, int left, int middle, int right) {
		int current1 = middle;
		int current2 = right;
		int current3 = right-left;
		int temp[] = new int[right-left+1];
		int pairsNum = 0;
		while (current1 >= left && current2 >= middle + 1) {
			if (array[current1] > array[current2]) {
				temp[current3--] = array[current1--];
				pairsNum += (current2 - middle);
				//数值过大求余
				if (pairsNum > 1000000007) {
					pairsNum %= 1000000007;
				}
			}
			else {
				temp[current3--] = array[current2--];
			}
		}
		while (current1 >= left) {
			temp[current3--] = array[current1--];
		}
		while (current2 >= middle + 1) {
			temp[current3--] = array[current2--];
		}
		//将临时数组赋值给原数组
		int i = 0;
		while(left <= right){
			array[left++] = temp[i++];
		}
		return pairsNum;
	}
}