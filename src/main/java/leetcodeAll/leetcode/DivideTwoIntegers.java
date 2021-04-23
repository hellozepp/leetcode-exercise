package leetcodeAll.leetcode;

/**
 * 29. Divide Two Integers
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * @author Watcher
 *
 */
public class DivideTwoIntegers {
	public static void main(String[] args) {
		DivideTwoIntegers so = new DivideTwoIntegers();
		System.out.println(so.divide(-2147483648, 2));
	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		long dvd = Math.abs((long) dividend);
		long dvs = Math.abs((long) divisor);
		int res = 0;
		while (dvs <= dvd) {
			long tmp = dvs;
			int mul = 1;
			while (dvd > (tmp << 1)) {
				tmp <<= 1;
				mul <<= 1;
			}
			res += mul;
			dvd -= tmp;
		}
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			return -res;
		else
			return res;
	}
}
