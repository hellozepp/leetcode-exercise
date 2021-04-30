/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题48：最长不含重复字符的子字符串
 * // 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * // 字符串的长度。假设字符串中只包含从'a'~'z'的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串
 * // 是"acfr"，长度为4。
 */
package offer;
import java.util.HashMap;
import java.util.Map;

public class Java48_LongestSubstringWithoutDup {
	/** 基本思想：HashMap中不断更新维护每个字符出现的位置。使用count变量进行计数，当统计的最长子字符串被重复字符破坏时，
	比较count和max的大小，判断是否需要更新max变量。*/
	public static int LongestSubstringWithoutDup(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		// 建立一个HashMap用来存放字符和位置信息
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		//用来记录最大值
		int max = 0; 
		//用来统计长度
		int count = 0; 
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (!map.containsKey(c[i])) {
				map.put(c[i], i);
				count++;
			}
			else {
				//若map中已经包含该字符，分为两种情况讨论
				Integer index = map.get(c[i]);
				//情况1：上次出现的该字符并不在当前所统计的最长字符串中，只需要更新位置信息。并且统计count++
				if (i - index > count) {
					count++;
					map.put(c[i], i);
					continue;
				}
				//情况2：上次出现的该字符影响了当前最长不重复的子字符串
				//则更新位置信息、max变量和count计数
				map.put(c[i], i);
				if (count > max) {
		    		max = count;
		    	}
				count = i - index;
			}
		}
		// 防止出现没有重复字符的情况，此时max = 0
		return max > count ? max: count;
	}
	
	public static void main(String[] args) {
		System.out.println(LongestSubstringWithoutDup("arbacacfr"));
		System.out.println(LongestSubstringWithoutDup("hkcpmprxxxqw"));
		System.out.println(LongestSubstringWithoutDup("dvdf"));
		System.out.println(LongestSubstringWithoutDup("tmmzuxt"));
		System.out.println(LongestSubstringWithoutDup("jbpnbwwd"));
	}
}