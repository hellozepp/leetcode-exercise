package leetcodeAll.leetcode;

/**
 * 96. Unique Binary Search Trees
 * 
 * @author Watcher
 *
 */
public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				dp[i] += dp[j] * dp[i - 1 - j];
		return dp[n];
	}

}
