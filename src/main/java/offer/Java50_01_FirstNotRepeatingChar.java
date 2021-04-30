/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题50（一）：字符串中第一个只出现一次的字符
 * // 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 */
package offer;
import java.util.HashMap;

public class Java50_01_FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (hashMap.containsKey(str.charAt(i))) {
				int time = hashMap.get(str.charAt(i));
				hashMap.put(str.charAt(i), ++time);
			}
			else {
				hashMap.put(str.charAt(i), 1);
			}
		}
		int pos = -1;
		int i = 0;
		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hashMap.get(c) == 1) {
				return i;
			}
		}
		return pos;
	}
}
