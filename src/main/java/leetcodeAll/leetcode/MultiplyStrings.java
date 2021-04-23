package leetcodeAll.leetcode;

/**
 * 43. Multiply Strings
 * 
 * @author Watcher
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		// MultiplyStrings so = new MultiplyStrings();
//		char[] cs = { '0' };
//		char[] cs2 = { '1' };
		// System.out.println(so.add(cs, cs2));
		// System.out.println(so.multiply("0", "110"));
	}

	/**
	 * 各位累加，耗时14ms，最快
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		int[] mul = new int[n1.length + n2.length - 1];
		for (int i = 0; i < n1.length; i++) {
			for (int j = 0; j < n2.length; j++) {
				mul[i + j] += (n1[i] - '0') * (n2[j] - '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		int sign = 0;
		for (int i = mul.length - 1; i >= 0; i--) {
			sb.append((mul[i] + sign) % 10);
			sign = (mul[i] + sign) / 10;
		}
		if (sign > 0)
			sb.append(sign);
		return sb.reverse().toString();
	}

	/**
	 * 位置转移，耗时16ms
	 * 
	 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA
	 * -Solution-with-Graph-Explanation
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		int[] pos = new int[n1.length + n2.length];
		for (int i = n1.length - 1; i >= 0; i--) {
			for (int j = n2.length - 1; j >= 0; j--) {
				int num = (n1[i] - '0') * (n2[j] - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = num + pos[p2];
				pos[p1] += sum / 10;
				pos[p2] = sum % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.toString();
	}

	/**
	 * 暴力求解，复杂且慢。耗时51ms
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply3(String num1, String num2) {
		if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty())
			return null;
		if (num1.length() < num2.length())
			return multiply3(num2, num1); // 保证num1的长度大于num2
		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		char[][] sum = new char[n2.length][]; // 初步的乘积
		for (int i = 0; i < n2.length; i++) {
			sum[n2.length - i - 1] = mult(n2[i], n1); // n2第i位位与n1的乘积
		}
		for (int i = 1; i < sum.length; i++) {
			int cnt = i;
			String tmp = new String(sum[i]);
			while (cnt > 0) {
				tmp += 0;
				cnt--;
			}
			sum[i] = tmp.toCharArray();
		}
		for (int i = 1; i < sum.length; i++) { // 错位相加
			sum[i] = add(sum[i - 1], sum[i]);
		}
		return new String(sum[sum.length - 1]);
	}

	private char[] add(char[] num1, char[] num2) {
		if (num1.length == 1 && num1[0] == '0')
			return num2;
		if (num2.length == 1 && num2[0] == '0')
			return num1;
		StringBuilder res = new StringBuilder();
		int sign = 0;
		int i = num1.length - 1, j = num2.length - 1;
		while (i >= 0 && j >= 0) {
			int val1 = num1[i] - '0';
			int val2 = num2[j] - '0';
			res.insert(0, (val1 + val2 + sign) % 10);
			sign = (val1 + val2 + sign) / 10;
			i--;
			j--;
		}
		while (i >= 0) {
			int val1 = num1[i] - '0';
			res.insert(0, (val1 + sign) % 10);
			sign = (val1 + sign) / 10;
			i--;
		}
		while (j >= 0) {
			int val2 = num2[j] - '0';
			res.insert(0, (val2 + sign) % 10);
			sign = (val2 + sign) / 10;
			j--;
		}
		if (sign > 0)
			res.insert(0, sign);
		return res.toString().toCharArray();
	}

	private char[] mult(char c, char[] n1) {
		int num = c - '0';
		if (num == 0)
			return new char[] { '0' };
		if (num == 1)
			return n1;
		StringBuilder res = new StringBuilder();
		int sign = 0; // 进位
		for (int i = n1.length - 1; i >= 0; i--) {
			int cur = n1[i] - '0';
			res.insert(0, (cur * num + sign) % 10);
			sign = (cur * num + sign) / 10;
		}
		if (sign > 0)
			res.insert(0, sign);
		return res.toString().toCharArray();
	}
}
