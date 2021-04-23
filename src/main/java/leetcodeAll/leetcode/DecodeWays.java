package leetcodeAll.leetcode;

/**
 * 91. Decode Ways
 * 
 * @author Watcher
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		new DecodeWays().numDecodings("99");
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.startsWith("0"))
			return 0;
		char[] cs = s.toCharArray();
		int[] dp = new int[cs.length + 1];
		dp[0] = dp[1] = 1;
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == '0' && (cs[i - 1] == '0' || cs[i - 1] > '2'))
				return 0;
			if (cs[i] == '0')
				dp[i + 1] = dp[i] = dp[i - 1];
			else {
				int tmp = (cs[i - 1] - '0') * 10 + cs[i] - '0';
				if (tmp > 26 || cs[i - 1] == '0')
					dp[i + 1] = dp[i];
				else
					dp[i + 1] = dp[i] + dp[i - 1];
			}
		}
		return dp[cs.length];
	}
}
