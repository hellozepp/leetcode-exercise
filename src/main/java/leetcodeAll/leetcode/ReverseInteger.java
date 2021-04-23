package leetcodeAll.leetcode;

/**
 * 7. Reverse Integer
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * @author Watcher
 *
 */
public class ReverseInteger {

	/**
	 * 按位翻转
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = (res << 1) + (res << 3) + x % 10;
			x /= 10;
		}
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			return 0;
		else
			return (int) res;
	}

	/**
	 * 转换成字符串翻转，再转成数字，如果解析失败则返回0
	 * 
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		int s = x >= 0 ? 1 : -1;
		String str = s == 1 ? x + "" : (x + "").substring(1);
		try {
			return Integer.parseInt(new StringBuilder(str).reverse().toString()) * s;
		} catch (Exception e) {
			return 0;
		}
	}
}
