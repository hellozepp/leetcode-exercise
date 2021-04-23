package leetcodeAll.leetcode;

/**
 * * 10. Regular Expression Matching
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support
 * for '.' and '*'.
 * <p>
 * '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching
 * should cover the entire input string (not partial).
 *
 * @author Watcher
 */
public class RegularExpressionMatching {

    /**
     * 动态规划，根据递归改编，记录递归的状态，耗时最少
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int m = ss.length, n = ps.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean first = i < m && (ss[i] == ps[j] || ps[j] == '.');
                if (j + 1 < n && ps[j + 1] == '*')
                    dp[i][j] = dp[i][j + 2] || (first && dp[i + 1][j]);
                else
                    dp[i][j] = first && dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }

    /**
     * 递归版，耗时较少
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch2(s, p.substring(2)) || (first && isMatch2(s.substring(1), p));
        } else {
            return first && isMatch2(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch4(char[] cs, int i, char[] cp, int j) {
        if (j == cp.length)
            return i == cs.length;
        boolean first = i != cs.length && (cs[i] == cp[j] || cp[j] == '.');
        if (j + 1 < cp.length && cp[j + 1] == '*') {
            return isMatch4(cs, i, cp, j + 2) || (first && isMatch4(cs, i + 1, cp, j));
        } else {
            return first && isMatch4(cs, i + 1, cp, j + 1);
        }
    }

    /**
     * 从开始位置匹配，分情况讨论。耗时最久
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {
        if (p == null || s == null)
            return false;
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {
        int m = s.length(), n = p.length();
        if (m == i && n == j)
            return true;
        if (m != i && j >= n)
            return false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // 模式串中当前字符的下一个字符为*
            // 分为四种情况，1：不匹配，i不变，j+=2 2:匹配，i+1,j不变 3：匹配 i+1，j+=2 4:匹配 i不变，j+=2;
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                return match(s, p, i + 1, j) || match(s, p, i + 1, j + 2) || match(s, p, i, j + 2);
            else
                return match(s, p, i, j + 2);
        } else {
            if (j < p.length() && i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
                return match(s, p, i + 1, j + 1);
            else
                return false;
        }
    }
}
