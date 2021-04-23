package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 * 
 * @author Watcher
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return res;
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] cs = str.toCharArray();
			Arrays.sort(cs);
			String s = new String(cs);
			if (map.containsKey(s))
				map.get(s).add(str);
			else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, list);
				res.add(list); // 不需要再次遍历map，这里添加到res即可，引用对象，res中存放的时地址值
			}
		}
//		for (String key : map.keySet())
//			res.add(map.get(key));
		return res;
	}
}
