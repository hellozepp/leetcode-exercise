package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all
 * starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 * 
 * @author Watcher
 *
 */
public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sOfAllWords = new SubstringWithConcatenationOfAllWords();
		String str = "barfoothefoobarman";
		List<String> wList = new LinkedList<String>();
		wList.add("ab");
		wList.add("ba");
		wList.add("ba");
		// System.out.println(sOfAllWords.isMatch(str, wList));
		String[] words = { "foo", "bar" };
		System.out.println(sOfAllWords.findSubstring(str, words));
	}

	/**
	 * 滑动窗口：时间复杂度O(n)，必须掌握。耗时13ms 最快
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)
			return list;
		int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
		if (sLen < wLen * wsLen)
			return list;
		Map<String, Integer> map = new HashMap<>(); // 记录words中每一个字符串的数目
		for (String word : words) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
		for (int i = 0; i < wLen; i++) {
			int left = i, right = i, window = 0; // 窗口的大小和左右边界
			while (right + (wsLen - window) * wLen <= sLen && right + wLen <= sLen) {
				String cur = s.substring(right, right + wLen); // right位置的字符串
				if (map.containsKey(cur)) {
					int cnt = map.get(cur); // 当前字符串的个数
					window++; // 包含当前字符串，窗口大小+1
					if (cnt > 0) {
						map.put(cur, cnt - 1);
					} else { // map当前字符串个数为0，说明出现重复字符串
						String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
						while (!removed.equals(cur)) {
							map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
							left += wLen;
							window--;
							removed = s.substring(left, left + wLen);
						}
						left += wLen;
						window--;
					}
					if (window == wsLen) // 窗口大小等于数组长度，匹配成功
						list.add(left);
				} else {
					// 恢复map
					window = 0;
					while (left < right) {
						String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
						map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
						left += wLen;
					}
					left += wLen; // 左边跳过当前这一位不匹配的字符串
				}
				right += wLen; // 窗口往右拓展一个字符串的长度
			}
			// 恢复map
			while (left < right) {
				String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
				map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
				left += wLen;
			}
		}
		return list;
	}

	/**
	 * 暴力匹配，耗时830ms，不建议使用
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if (s == null || s.isEmpty() || words == null || words.length == 0)
			return list;
		int sLen = s.length(), wLen = 0;
		for (String str : words)
			wLen += str.length();
		if (sLen < wLen)
			return list;
		List<String> wList = new LinkedList<String>(Arrays.asList(words));
		for (int i = 0; i <= sLen - wLen; i++) {
			if (isMatch(s.substring(i, i + wLen), new LinkedList<String>(wList))) {
				list.add(i);
			}
		}
		return list;
	}

	private boolean isMatch(String str, List<String> wList) {
		if (wList.isEmpty())
			return true;
		for (String s : wList) {
			if (!str.contains(s))
				return false;
			if (str.startsWith(s)) {
				wList.remove(s);
				return isMatch(str.substring(s.length()), wList);
			}
		}
		return false;
	}
}
