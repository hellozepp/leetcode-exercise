package leetcodeAll.leetcode;

/**
 * 9. Palindrome Number
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same
 * backward as forward.
 * 
 * @author Watcher
 *
 */
public class PalindromeNumber {

	/**
	 * 转换成数组，比较对应位置
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int i = 0;
		char[] cs = (x + "").toCharArray();
		int len = cs.length;
		while (i != len / 2) {
			if (cs[i] != cs[len - i - 1])
				return false;
			i++;
		}
		return true;
	}

	/**
	 * 转成字符串，翻转，比较。
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		return new StringBuilder(x + "").reverse().toString().equals(x + "");
	}

	/**
	 * 类似于翻转数字，只需要翻转一半
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome3(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
	}
}
