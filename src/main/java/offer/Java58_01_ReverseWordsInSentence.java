/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题58（一）：翻转单词顺序
 * // 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * // 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * // 则输出"student. a am I"。
 */
package offer;

public class Java58_01_ReverseWordsInSentence {
	public String ReverseSentence(String str) {
		if (str == null) {
			return null;
		}
		if (str.trim().equals("")) {
			return str;
		}
		String stringCopy = str;
		String[] stringArray = stringCopy.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = stringArray.length-1; i >= 0; i--) {
			if (i == 0) {
				stringBuilder.append(stringArray[i]);
			}
			else {
				stringBuilder.append(stringArray[i]);
				stringBuilder.append(" ");
			}
		}
		String stringResult = stringBuilder.toString();
		return stringResult;
	}
}