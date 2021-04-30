/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题11：旋转数组的最小数字
 * // 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * // 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * // {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
package offer;
import java.util.ArrayList;

public class Java11_MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
        	return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        
        //当low和high两个指针相邻的时候，也就找到了最小值，即右边序列的第一个值
        while (array[low] >= array[high]) {
        	if (high - low == 1) {
        		mid = high;
        		break;
        	}
        	//如果low, high, mid下标所指的值相等，如{1, 0, 1, 1, 1}和{1, 1, 1, 0, 1}
        	//都可看成{0, 1, 1, 1, 1}旋转而成
        	if (array[low] == array[high] && array[mid] == array[low]) {
        		return MinInOrder(array);
        	}
        	mid = (low + high) / 2;
        	if (array[mid] >= array[low]) {
        		low = mid;
        	}
        	else if (array[mid] <= array[high]) {
        		high = mid;
        	}
        }
        return array[mid];
    }
    
    private int MinInOrder(int[] array) {
    	int min = array[0];
    	for (int i = 1; i < array.length; i++) {
    		if (array[i] < min) {
    			min = array[i];
    		}
    	}
    	return min;
    }
}
