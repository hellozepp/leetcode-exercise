package leetcodeAll.leetcode9;

/**
 * * 868. Binary Gap
 * 
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in
 * the binary representation of N.
 * 
 * If there aren't two consecutive 1's, return 0.
 * 
 * @author Watcher
 *
 */
public class BinaryGap {

	/**
	 * 代码简化，但是耗时11ms，多了1ms。如果把while修改成for循环，耗时9ms
	 * 
	 * @param n
	 * @return
	 */
	public int binaryGap(int n) {
		int res = 0, cur = -32;
		while (n > 0) {
			if ((n & 1) == 1) {
				res = Math.max(res, cur);
				cur = 0;
			}
			n >>= 1;
			cur++;
		}
		return res;
	}

	/**
	 * 周测时写的版本，有待优化，耗时10ms
	 * 
	 * @param N
	 * @return
	 */
	public int binaryGap2(int N) {
		int cnt = 0;
		int start = 0, end = 0;
		while (N > 0) {
			if ((N & 1) == 1) {
				// 当前位为1
				break;
			}
			N >>= 1;
			end++;
		}
		start = end;
		while (N > 0) {
			if ((N & 1) == 1) {
				// 当前位为1
				cnt = Math.max(cnt, end - start);
				start = end;

			}
			N >>= 1;
			end++;
		}
		return cnt;
	}
}
