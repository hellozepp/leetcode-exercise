package leetcodeAll.leetcode;

/**
 * 62. Unique Paths
 * 
 * @author Watcher
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths so = new UniquePaths();
		System.out.println(so.uniquePaths(3, 2));
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1]; // dp[i][j]表示i行j列的路线总数
		dp[0][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m][n];
	}
}
