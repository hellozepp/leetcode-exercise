package leetcodeAll.leetcode;

/**
 * 97. Interleaving String
 * 
 * @author Watcher
 *
 */
public class InterleavingString {

	/**
	 * 耗时2ms
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null)
			return s2.equals(s3);
		if (s2 == null)
			return s1.equals(s3);
		if (s1.length() + s2.length() != s3.length())
			return false;
		int m = s1.length(), n = s2.length();
		char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
		boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j]表示s1的前i个字符和s2的前j个字符是否能够组成s3的前i+j个字符
		dp[0][0] = true;
		for (int i = 1; i <= m; i++)
			dp[i][0] = dp[i - 1][0] && cs1[i - 1] == cs3[i - 1];
		for (int i = 1; i <= n; i++)
			dp[0][i] = dp[0][i - 1] && cs2[i - 1] == cs3[i - 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1]) || (dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1]);
			}
		}
		return dp[m][n];
	}

	/**
	 * 耗时0ms
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s1 == null)
			return s2.equals(s3);
		if (s2 == null)
			return s1.equals(s3);
		if (s1.length() + s2.length() != s3.length())
			return false;
		return judge(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), new int[s1.length() + 1][s2.length() + 1]);
	}

	private boolean judge(char[] cs1, int i, char[] cs2, int j, char[] cs3, int[][] dp) {
		if (dp[i][j] != 0)
			return dp[i][j] == 1;
		if (i == cs1.length) {
			if (new String(cs2, j, cs2.length - j).equals(new String(cs3, i + j, cs3.length - i - j))) {
				dp[i][j] = 1;
				return true;
			}
			dp[i][j] = 2;
			return false;
		} else if (j == cs2.length) {
			if (new String(cs1, i, cs1.length - i).equals(new String(cs3, i + j, cs3.length - i - j))) {
				dp[i][j] = 1;
				return true;
			}
			dp[i][j] = 2;
			return false;
		} else {
			if ((cs1[i] == cs3[i + j] && judge(cs1, i + 1, cs2, j, cs3, dp)) || (cs2[j] == cs3[i + j] && judge(cs1, i, cs2, j + 1, cs3, dp))) {
				dp[i][j] = 1;
				return true;
			}
			dp[i][j] = 2;
			return false;
		}
	}
}
