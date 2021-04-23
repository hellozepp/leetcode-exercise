package leetcodeAll.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * * 140. Word Break II
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add
 * spaces in s to construct a sentence where each word is a valid dictionary word. Return all such
 * possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the segmentation. You may assume
 * the dictionary does not contain duplicate words.
 * 
 * @author Watcher
 *
 */
public class WordBreakII {

	/**
	 * 深度优先搜索
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public List<String> wordBreak(String s, List<String> wordDict) {
		return DFS(s, wordDict, new HashMap<>());
	}

	private List<String> DFS(String s, List<String> dict, HashMap<String, ArrayList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);
		ArrayList<String> list = new ArrayList<String>();
		if (s.length() == 0) {
			list.add("");
			return list;
		}
		for (String subStr : dict) {
			if (s.startsWith(subStr)) {
				for (String str : DFS(s.substring(subStr.length()), dict, map)) {
					list.add(subStr + (str == "" ? "" : " ") + str);
				}
			}
		}
		map.put(s, list);
		return list;
	}
}
