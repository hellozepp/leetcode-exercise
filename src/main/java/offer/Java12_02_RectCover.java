/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题12：矩阵覆盖
 * // 题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的
 * // 小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
package offer;

public class Java12_02_RectCover {
	public int RectCover(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1){
			return 1;
		}
		if (target * 2 == 2) {
			return 1;
		}
		else if (target * 2 == 4) {
			return 2;
		}
		else {
			return RectCover((target - 1)) + RectCover(target - 2);
		}
	}
}
