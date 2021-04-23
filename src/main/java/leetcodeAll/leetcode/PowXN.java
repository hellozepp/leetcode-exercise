package leetcodeAll.leetcode;

/**
 * 50. Pow(x, n)
 * 
 * @author Watcher
 *
 */
public class PowXN {

	public static void main(String[] args) {
		PowXN so = new PowXN();
		System.out.println(so.myPow(2, -2147483648));
	}

	/**
	 * 二分递归
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			return ((n & 1) == 0) ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
		}
		return ((n & 1) == 0) ? myPow(x * x, n >> 1) : x * myPow(x * x, n >> 1);
	}

	/**
	 * 直接二分计算
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
		if (x == 0 && n < 0)
			return -1;
		if (n == 0)
			return 1;
		double res = 1;
		int sign = n > 0 ? 1 : -1;
		long N = Math.abs((long) n);
		while (N > 0) {
			if (res == 0)
				return res;
			long tmp = 1;
			double resTmp = x;
			while (N >= (tmp << 1)) { // n>2*tmp
				resTmp *= resTmp;
				tmp <<= 1;
			}
			res *= resTmp;
			N -= tmp;
		}
		return sign == 1 ? res : (1 / res);
	}
}
