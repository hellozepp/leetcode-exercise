package leetcodeAll.leetcode2;

import java.util.*;

/**
 * 127. Word Ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!set.contains(endWord))
            return 0;
        start.add(beginWord);
        end.add(endWord);
        return help(start, end, set, 1);
    }

    private int help(Set<String> start, Set<String> end, Set<String> set, int path) {
        if (start.isEmpty() || end.isEmpty())
            return 0;
        if (start.size() > end.size())
            return help(end, start, set, path);
        Set<String> next = new HashSet<>();
        set.removeAll(start);
        for (String str : start) {
            char[] cs = str.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char old = cs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (old == j)
                        continue;
                    cs[i] = j;
                    String newStr = String.valueOf(cs);
                    if (end.contains(newStr))
                        return path + 1;
                    if (set.contains(newStr))
                        next.add(newStr);
                }
                cs[i] = old;
            }
        }
        return help(next, end, set, path + 1);
    }
}
