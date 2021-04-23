package leetcodeAll.leetcode;

/**
 * 67. Add Binary
 * 
 * @author Watcher
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a.length() < b.length())
			return addBinary(b, a);
		StringBuilder sb = new StringBuilder();
		int sign = 0, m = a.length(), n = b.length();
		int index = m - 1;
		while (index >= m - n) {
			int tmp = a.charAt(index) - '0' + b.charAt(index-- - m + n) - '0' + sign;
			sb.append(tmp % 2);
			sign = tmp >> 1;
		}
		int i = m - n - 1;
		while (i >= 0) {
			int tmp = a.charAt(i--) - '0' + sign;
			sb.append(tmp % 2);
			sign = tmp >> 1;
		}
		if (sign != 0)
			sb.append(sign);
		return sb.reverse().toString();
	}
}
