package leetcodeAll.leetcode;

/**
 * 70. Climbing Stairs
 * 
 * @author Watcher
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs so = new ClimbingStairs();
		System.out.println(so.climbStairs(44));
	}

	/**
	 * 动态规划版本
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++)
			dp[i] += dp[i - 1] + dp[i - 2];
		return dp[n - 1];
	}

	/**
	 * 暴力递归，耗时长，超时
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}
}
