/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题50（二）：字符流中第一个只出现一次的字符
 * // 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
 * // 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
 * // 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
package offer;
import java.util.HashMap;
import java.util.ArrayList;

public class Java50_02_FirstCharacterInStream {
	HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
	ArrayList<Character> list = new ArrayList<Character>();
	public void Insert(char ch) {
		if (hashMap.containsKey(ch)) {
			hashMap.put(ch, hashMap.get(ch) + 1);
		}
		else {
			hashMap.put(ch, 1);
		}
		list.add(ch);
	}
	
	public char FirstAppearingOnce() {
		char c = '#';
		for (char key : list) {
			if (hashMap.get(key) == 1) {
				c = key;
				break;
			}
		}
		return c;
	}
}
