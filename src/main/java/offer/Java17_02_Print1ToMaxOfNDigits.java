/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题17：打印1到最大的n位数
 * // 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * // 打印出1、2、3一直到最大的3位数即999。
 */
package offer;

public class Java17_02_Print1ToMaxOfNDigits {
	//递归
	public static void Print1ToMaxOfNDigits(int n) {
		if (n <= 0) 
			return;
		char [] number = new char[n];
		
		for (int i = 0; i < 10; i++) {
			number[i] = (char)(i + '0');
			Print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	public static void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if (index == length - 1) {
			PrintNumber(number);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char)(i + '0');
			Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
		}
	}
	
	//字符串number表示一个数字，数字有若干个0开头，打印出这个数字，并忽略开头的0
	public static void PrintNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		
		//标志位的思想，从第一位不为0的数字开始打印
		for (int i = 0; i < nLength; i++) {
			if (isBeginning0 && number[i] != '0')
				isBeginning0 = false;
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
}
