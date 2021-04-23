package leetcodeAll.leetcode;

/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * @author Watcher
 *
 */
public class StringToInteger {

	/**
	 * 注意结束条件
	 * 
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		if (str == null || str.trim().length() == 0)
			return 0;
		str = str.trim(); // 移除str两侧的空格
		int s = str.charAt(0) == '-' ? -1 : 1; // 是否需要乘以-1
		StringBuilder sb = new StringBuilder(); // 存放数字组成的字符串
		for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0); i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9')
				break; // 遇到非数字字符立即结束循环
			sb.append(ch);
		}
		if (sb.length() == 0) // 前面不是数字，直接返回0
			return 0;
		try {
			return s * Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return s == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
	}
}
