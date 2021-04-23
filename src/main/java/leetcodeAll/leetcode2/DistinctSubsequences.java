package leetcodeAll.leetcode2;

import java.util.Arrays;

/**
 * 115. Distinct Subsequences
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        int[][] dp = new int[cs.length + 1][ct.length + 1];
        for (int i = 1; i <= cs.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= ct.length; j++)
                if (cs[i - 1] == ct[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[cs.length][ct.length];
    }

    public int numDistinct2(String s, String t) {
        char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();
        int[] first = new int[128];
        Arrays.fill(first, -1);
        int[] pre = new int[ch2.length];
        for (int i = 0; i < ch2.length; i++) {
            pre[i] = first[ch2[i]];
            first[ch2[i]] = i+1;
        }
        int[] dp = new int[ch2.length+1];
        dp[0] = 1;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = first[ch1[i]]; j != -1; j = pre[j-1])
                dp[j] += dp[j-1];
        }
        return dp[ch2.length];
    }
}
