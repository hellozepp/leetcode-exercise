/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题5：替换空格
 * // 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * // 则输出“We%20are%20happy.”。
 */
package offer;

public class Java05_02_ReplaceSpaces {
	public String replaceSpace(StringBuffer str) {
		if (str == null)
			return null;
		int numberOfBlank = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				numberOfBlank++;
        }
		int newLength = str.length() + numberOfBlank * 2;
		int indexOfOriginal = str.length() - 1;
		int indexOfNew = newLength - 1;
		str.setLength(newLength);
		while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
			if (str.charAt(indexOfOriginal) == ' ') {
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
            	str.setCharAt(indexOfNew--, '%');
            }
			else {
				str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
			indexOfOriginal--;
        }
		return str.toString();
    }
	
	//测试用例
	public static void main(String[] args) {
		Java05_02_ReplaceSpaces testString = new Java05_02_ReplaceSpaces();
		//输入的字符串包含空格在：最后面，最前面，中间，连续空格和无空格
		StringBuffer str1 = new StringBuffer("We are happy.");
		StringBuffer str2 = new StringBuffer(" Wearehappy.");
		StringBuffer str3 = new StringBuffer("Wearehappy. ");
		StringBuffer str4 = new StringBuffer("We  are  happy  .");
		StringBuffer str5 = new StringBuffer("Wearehappy.");
		//输入特殊测试：字符串只有连续空格，一个空格，字符串是一个null指针，字符串是一个空字符串
		StringBuffer str6 = new StringBuffer("   ");
		StringBuffer str7 = new StringBuffer(" ");
		StringBuffer str8 = null;
		StringBuffer str9 = new StringBuffer("");
		System.out.println(testString.replaceSpace(str1));
		System.out.println(testString.replaceSpace(str2));
		System.out.println(testString.replaceSpace(str3));
		System.out.println(testString.replaceSpace(str4));
		System.out.println(testString.replaceSpace(str5));
		System.out.println(testString.replaceSpace(str6));
		System.out.println(testString.replaceSpace(str7));
		System.out.println(testString.replaceSpace(str8));
		System.out.println(testString.replaceSpace(str9));
	}
}
