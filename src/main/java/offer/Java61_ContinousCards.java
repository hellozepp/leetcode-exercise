/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题61：扑克牌的顺子
 * // 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
package offer;
import java.util.*;

public class Java61_ContinousCards {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null) {
			return false;
		}
		//先排序
		Arrays.sort(numbers);  
		int zero = 0, i = 0;
		for (; i < numbers.length && numbers[i] == 0; i++) {
			//统计0的个数
			zero ++;  
		}
		for (; i < numbers.length - 1 && zero >= 0; i++) {
			//有对子，则返回false
			if (numbers[i] == numbers[i+1]) {
				return false;
			}
			if (numbers[i] + 1 + zero >= numbers[i+1]) {
				//可以继续匹配
				zero -= numbers[i+1] - numbers[i] - 1;
			}
			else {
				return false;
			}
		}
		if (i == numbers.length -1) {
			return true;
		}
		else {
			return false;
		}
    }
}