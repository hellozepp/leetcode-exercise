package leetcodeAll.leetcode;

/**
 * 12. Integer to Roman
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * @author Watcher
 *
 */
public class IntegerToRoman {

	/**
	 * 精简
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		String[] nums1 = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }; // 1--9
		String[] nums2 = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }; // 10--90
		String[] nums3 = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }; // 100--900
		String[] nums4 = { "", "M", "MM", "MMM" }; // 1000--3000
		return nums4[num / 1000] + nums3[(num % 1000) / 100] + nums2[(num % 100) / 10] + nums1[num % 10];

	}

	/**
	 * 最开始想到的，正向思维，从小到大匹配罗马数字
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman2(int num) {
		String res = "";
		int m = 0, n = 1;
		while (num > 0) {
			m = (num % 10) * n;
			num /= 10; // 整数右移一位
			n *= 10; // n为补偿数
			if (m == 0)
				continue;
			String cur = toRoman(m);
			res = cur + res;
		}

		return res;
	}

	private String toRoman(int m) {
		String[] nums1 = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }; // 1--9
		String[] nums2 = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }; // 10--90
		String[] nums3 = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }; // 100--900
		String[] nums4 = { "M", "MM", "MMM" }; // 1000--3000
		if (m >= 1 && m <= 9) {
			return nums1[m - 1];
		}
		if (m >= 10 && m <= 90) {
			return nums2[m / 10 - 1];
		}
		if (m >= 100 && m <= 900) {
			return nums3[m / 100 - 1];
		}
		if (m >= 1000 && m <= 3000) {
			return nums4[m / 1000 - 1];
		}
		return null;
	}

}
