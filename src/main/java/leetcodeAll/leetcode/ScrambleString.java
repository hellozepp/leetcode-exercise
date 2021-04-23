package leetcodeAll.leetcode;

/**
 * 87. Scramble String
 * 
 * @author Watcher
 *
 */
public class ScrambleString {

	public static void main(String[] args) {
		new ScrambleString().isScramble("great", "treag");

	}

	/**
	 * 动态规划：耗时12ms
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
		int len = cs1.length;
		boolean[][][] dp = new boolean[len][len][len + 1];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				dp[i][j][1] = cs1[i] == cs2[j];
		for (int l = 2; l <= len; l++)
			for (int i = 0; i < len - l + 1; i++)
				for (int j = 0; j < len - l + 1; j++)
					for (int k = 1; k < l; k++)
						dp[i][j][l] = dp[i][j][l] || (dp[i][j][k] && dp[i + k][j + k][l - k]) || (dp[i][j + l - k][k] && dp[i + k][j][l - k]);
		return dp[0][0][len];
	}

	/**
	 * 递归实现：耗时3ms
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble2(String s1, String s2) {
		return isScramble(s1.toCharArray(), 0, s1.length() - 1, s2.toCharArray(), 0, s2.length() - 1);
	}

	private boolean isScramble(char[] cs1, int lo1, int hi1, char[] cs2, int lo2, int hi2) {
		if (hi1 - lo1 != hi2 - lo2)
			return false;
		if (lo1 == hi1)
			return cs1[lo1] == cs2[lo2];
		int[] cnt = new int[128];
		for (int i = lo1; i <= hi1; i++)
			cnt[cs1[i]]++;
		for (int i = lo2; i <= hi2; i++) {
			cnt[cs2[i]]--;
			if (cnt[cs2[i]] < 0)
				return false;
		}
		for (int i = lo1; i < hi1; i++) {
			if (isScramble(cs1, lo1, i, cs2, lo2, lo2 + i - lo1) && isScramble(cs1, i + 1, hi1, cs2, hi2 - hi1 + i + 1, hi2))
				return true;
			if (isScramble(cs1, lo1, i, cs2, hi2 - i + lo1, hi2) && isScramble(cs1, i + 1, hi1, cs2, lo2, lo2 + hi1 - i - 1))
				return true;
		}
		return false;
	}

}
