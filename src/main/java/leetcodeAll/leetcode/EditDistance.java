package leetcodeAll.leetcode;

/**
 * 72. Edit Distance
 * 
 * @author Watcher
 *
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		char[] ws1 = word1.toCharArray();
		char[] ws2 = word2.toCharArray();
		int[] dp = new int[len2 + 1]; // dp[i][j]表示ws1[0~i-1]编辑成ws2[0~j-1]的最小代价
		for (int i = 1; i <= len2; i++)
			dp[i] = i;
		for (int i = 1; i <= len1; i++) {
			int prev = i;
			for (int j = 1; j <= len2; j++) {
				int cur;
				if (ws1[i - 1] == ws2[j - 1])
					cur = dp[j - 1];
				else
					cur = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
				dp[j - 1] = prev;
				prev = cur;
			}
			dp[len2] = prev;
		}
		return dp[len2];
	}

	public int minDistance2(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		char[] ws1 = word1.toCharArray();
		char[] ws2 = word2.toCharArray();
		int[][] dp = new int[len1 + 1][len2 + 1]; // dp[i][j]表示ws1[0~i-1]编辑成ws2[0~j-1]的最小代价
		for (int i = 0; i <= len1; i++)
			dp[i][0] = i;
		for (int i = 1; i <= len2; i++)
			dp[0][i] = i;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (ws1[i - 1] == ws2[j - 1])
					// dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}
		return dp[len1][len2];
	}
}
