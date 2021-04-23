package leetcodeAll.leetcode;

/**
 * 64. Minimum Path Sum
 * 
 * @author Watcher
 *
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i == 0)
					grid[i][j] += grid[i][j - 1];
				else if (j == 0)
					grid[i][j] += grid[i - 1][j];
				else
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

	public int minPathSum2(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n]; // dp[i][j]表示前i+1行j+1列从左上角到右下角的最小和
		dp[0][0] = grid[0][0];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i == 0)
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				else if (j == 0)
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				else
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}
}
