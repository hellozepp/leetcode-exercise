package leetcodeAll.leetcode;

/**
 * 76. Minimum Window Substring
 * 
 * @author Watcher
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";
		int[] map = new int[128];
		for (char c : t.toCharArray())
			map[c]++;
		char[] cs = s.toCharArray();
		int start = 0, lo = 0, hi = 0, min = Integer.MAX_VALUE, cnt = t.length();
		while (hi < s.length()) {
			if (map[cs[hi++]]-- > 0)
				cnt--;
			while (cnt == 0) { // 找到所有t中的字符，hi处于最后一个字符的下一位置
				if (hi - lo < min) {
					min = hi - lo;
					start = lo;
				}
				if (map[cs[lo++]]++ == 0) // 找到第一个缺少的字符，lo处于第一个缺少的字符的下一位置
					cnt++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
	}
}
