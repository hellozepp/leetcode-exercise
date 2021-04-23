package leetcodeAll.leetcode;

import java.util.Arrays;

/**
 * * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 * 
 * @author Watcher
 *
 */
public class LongestPalindromicSubstring {

	/**
	 * 暴力拓展法，在每一个字符的位置像两边拓展，记录最大范围
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(cs, i, i);
			int len2 = expandAroundCenter(cs, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(char[] cs, int left, int right) {
		while (left >= 0 && right <= cs.length - 1 && cs[left] == cs[right]) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	/**
	 * 马拉车算法版本，但是实际测试耗时不比暴力拓展快，也许是字符串太短或者测试数据少，按道理这是最快的
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome3(String s) {
		return maxLcpsLength(s).replace("#", "");
	}

	/**
	 * 马拉车算法，寻找最大回文子串的长度，时间复杂度O(n)
	 * 
	 * @param str
	 * @return
	 */
	public char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) { // 在每一个字符两侧插入#
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	/**
	 * 修改版马拉车算法，返回最大回文子串(包含#)
	 * 
	 * @param str
	 * @return
	 */
	public String maxLcpsLength(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() <= 1)
			return str;
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int left = 0, end = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			// max = Math.max(max, pArr[i]);
			if (max < pArr[i]) {
				max = pArr[i];
				end = i + max;
				left = i - max + 1;
			}
		}
		return new String(Arrays.copyOfRange(charArr, left, end));
	}

	/**
	 * 正常的马拉车算法，求最大回文子串长度
	 * 
	 * @param str
	 * @return
	 */
	public int maxLcpsLength2(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			// max = Math.max(max, pArr[i]);
			if (max < pArr[i]) {
				max = pArr[i];
			}
		}
		return max - 1;
	}

	/**
	 * 动态规划版本，时间复杂度O(n²)，但是测试效果并不比暴力拓展快
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		if (s == null)
			return null;
		if (s.length() <= 1)
			return s;
		char[] cs = s.toCharArray();
		int start = 0, end = 0, len = cs.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len - 1; i++) {
			dp[i][i] = 1;
			if (cs[i] == cs[i + 1]) {
				dp[i][i + 1] = 1;
				start = i;
				end = i + 1;
			} else
				dp[i][i + 1] = 0;
		}
		dp[len - 1][len - 1] = 1;
		for (int k = 3; k <= len; k++) {
			for (int i = 0; i < len - k + 1; i++) {
				int j = i + k - 1;
				if (cs[i] == cs[j] && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					start = i;
					end = i + 1;
				} else
					dp[i][j] = 0;
			}
		}

		return s.substring(start, end + 1);
	}
}
