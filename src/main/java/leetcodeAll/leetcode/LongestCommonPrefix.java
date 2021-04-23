package leetcodeAll.leetcode;

/**
 * 14. Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * @author Watcher
 *
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1)
			return "";
		if (strs.length == 1)
			return strs[0];
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (res.isEmpty())
				return "";
			else
				res = commonPrefix(res, strs[i]);
		}
		return res;
	}

	/**
	 * 返回两个字符串的共同前缀
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private String commonPrefix(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty())
			return "";
		int i = 0;
		while (i < s1.length() && i < s2.length()) {
			if (s1.charAt(i) == s2.charAt(i))
				i++;
			else
				break;
		}
		return s1.substring(0, i);
	}

}
