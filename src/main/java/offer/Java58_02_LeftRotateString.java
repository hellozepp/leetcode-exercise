/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题58（二）：左旋转字符串
 * // 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * // 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
 * // 字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
package offer;

public class Java58_02_LeftRotateString {
	public String LeftRotateString(String str, int n) {
		char[] charArray = str.toCharArray();
		if (charArray.length > 0 && n > 0 && charArray.length > n) {
			reverse(charArray, 0, n - 1);
			reverse(charArray, n, charArray.length - 1);
			reverse(charArray, 0, charArray.length - 1);
		}
		StringBuilder stringBuilder = new StringBuilder(charArray.length);
		for (char c: charArray) {
			stringBuilder.append(c);
		}
        return stringBuilder.toString();
    }

	public void reverse(char[] chars, int low, int high) {
		char temp;
		while (low < high) {
		    temp = chars[low];
		    chars[low] = chars[high];
		    chars[high] = temp;
		    low++;
		    high--;
		}
	}
}