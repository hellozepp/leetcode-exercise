package leetcodeAll.leetcode;

/**
 * 66. Plus One
 * 
 * @author Watcher
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int index = digits.length - 1;
		int sign = 0;
		digits[index] += 1;
		while (index >= 0) {
			int tmp = digits[index] + sign;
			digits[index--] = tmp % 10;
			sign = tmp / 10;
			if (sign == 0)
				return digits;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		for (int i = 0; i < digits.length; i++)
			res[i + 1] = digits[i];
		return res;
	}
}
