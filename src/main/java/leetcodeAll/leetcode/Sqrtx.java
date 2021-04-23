package leetcodeAll.leetcode;

/**
 * 69. Sqrt(x)
 * 
 * @author Watcher
 *
 */
public class Sqrtx {

	public int mySqrt(int x) {
		if (x <= 1)
			return x;
		int start = 0, end = x, mid = 0;
		while (start <= end) {
			mid = start + ((end - start) >> 1);
			if (x / mid > mid)
				start = mid + 1;
			else if (x / mid < mid)
				end = mid - 1;
			else
				return mid;
		}
		return end;
	}

	public int mySqrt3(int x) {
		long n = 1;
		while (n * n <= x) {
			int tmp = 1;
			while ((n + (tmp << 1)) * (n + (tmp << 1)) <= x) {
				tmp <<= 1;
			}
			n += tmp;
		}
		return (int) (n - 1);
	}

	public int mySqrt2(int x) {
		return (int) Math.sqrt(x);
	}
}
