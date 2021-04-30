/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题49：丑数
 * // 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * // 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * // 习惯上我们把1当做第一个丑数。
 */
package offer;
import java.util.ArrayList;

public class Java49_UglyNumber {
	/** 基本思想是：每一个丑数必然是由之前的某个丑数与2，3或5的乘积得到的，这样下一个丑数就用之前的
	丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个要求的丑数。 */
	public int GetUglyNumber_Solution(int index) {
		if(index == 0) {
		    return 0;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (result.size() < index) {
		    int m2 = result.get(i2) * 2;
		    int m3 = result.get(i3) * 3;
		    int m5 = result.get(i5) * 5;
		    int min = Math.min(m2, Math.min(m3, m5));
		    result.add(min);
		    if (min == m2) {
		        i2++;
		    }
		    if (min == m3) {
		        i3++;
		    }
		    if (min == m5) {
		        i5++;
		    }
		}
		return result.get(result.size() - 1);
	}
}
