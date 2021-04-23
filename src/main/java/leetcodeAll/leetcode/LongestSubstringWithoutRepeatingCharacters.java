package leetcodeAll.leetcode;

/**
 * * 3. Longest Substring Without Repeating Characters
 * 
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * @author Watcher
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 用数组实现自定义哈希表
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() < 1)
			return 0;
		int max = 0;
		int[] chars = new int[128]; // 字符ASCII值作为下标，字符在s中的下标作为值
		for (int i = 0, j = 0; j < s.length(); j++) {
			i = Math.max(i, chars[s.charAt(j)]);
			max = Math.max(max, j - i);
			chars[s.charAt(j)] = j;
		}
		return max;
	}

	/**
	 * 字符串拼接版本，暴力，直接
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() < 1)
			return 0;
		if (s.length() == 1)
			return 1;
		int max = 0;
		int start = 0; // 不同字符的开始下标
		int end = 1;
		String subStr = "";
		while (end < s.length()) {
			subStr = s.substring(start, end);
			while (start < end) {
				if (subStr.contains(s.charAt(end) + "")) {
					// end下标对应的字符在子串中
					start++;
					subStr = s.substring(start, end);
				} else
					break;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}

		return max;
	}
}
