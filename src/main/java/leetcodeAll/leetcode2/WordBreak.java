package leetcodeAll.leetcode2;

import java.util.HashMap;
import java.util.List;

/**
 * 139. Word Break
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean res = false;
    private HashMap<String, Boolean> map = new HashMap<>();

    private boolean dfs(String s, List<String> dict) {
        if (map.containsKey(s))
            return map.get(s);
        if (s.length() == 0) {
            res = true;
            return true;
        }
        for (String str : dict) {
            if (s.startsWith(str)) {
                dfs(s.substring(str.length()), dict);
            }
        }
        map.put(s, res);
        return res;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];   //dp[i]表示能否匹配前i个字符
        dfs2(s, wordDict, dp, 0);
        return dp[s.length()];
    }

    private void dfs2(String s, List<String> dict, boolean[] dp, int index) {
        if (s.length() > 0)
            for (String str : dict) {
                int len = str.length();
                if (index + len < dp.length && dp[index + str.length()])
                    continue;
                if (s.startsWith(str)) {
                    dp[index + len] = true;
                    dfs2(s.substring(len), dict, dp, index + len);
                }
            }
    }
}
