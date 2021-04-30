/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题57（一）：和为s的两个数字
 * // 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
 * // 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
package offer;
import java.util.ArrayList;

public class Java57_01_TwoNumbersWithSum {
    /*
    * i,j分别表示数组两端；
    * 当array[i]+array[j]>S时，j-- 尾端向前移动，两数和减小；
    * 当array[i]+array[j]=S时，将array[i],array[j]依次添加到ArrayList中；
    * 当array[i]+array[j]<S时，i++前段向后移动，两数和增大。
    */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2) {
			return list;
		}
		int i=0, j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			}
			else if (array[i] + array[j] > sum) {
				j--;
			}
			else {
				i++;
			}
		}
		return list;
	}
}