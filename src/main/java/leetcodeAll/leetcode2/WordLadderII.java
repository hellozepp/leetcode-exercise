package leetcodeAll.leetcode2;

import java.util.*;

/**
 * 126. Word Ladder II
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        if (!set.contains(endWord))
            return res;
        start.add(beginWord);
        end.add(endWord);
        if (!help(start, end, set, map, true))
            return res;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        add(res, list, beginWord, endWord, map);
        return res;
    }

    private void add(List<List<String>> res, List<String> list, String beginWord, String endWord, Map<String, List<String>> map) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(beginWord))
            return;
        for (String str : map.get(beginWord)) {
            list.add(str);
            add(res, list, str, endWord, map);
            list.remove(list.size() - 1);
        }
    }

    private boolean help(Set<String> start, Set<String> end, Set<String> set, Map<String, List<String>> map, boolean reverse) {
        if (start.isEmpty() || end.isEmpty())
            return false;
        boolean found = false;
        set.removeAll(start);
        Set<String> next = new HashSet<>();
        for (String str : start) {
            char[] cs = str.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char old = cs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (old == j)
                        continue;
                    cs[i] = j;
                    String newStr = new String(cs);
                    if (set.contains(newStr)) {
                        if (end.contains(newStr))
                            found = true;
                        next.add(newStr);
                        String key = reverse ? str : newStr;
                        String value = reverse ? newStr : str;
                        if (!map.containsKey(key))
                            map.put(key, new ArrayList<>());
                        map.get(key).add(value);
                    }
                }
                cs[i] = old;
            }
        }
        if (found)
            return true;
        if (next.size() > end.size())
            return help(end, next, set, map, !reverse);
        return help(next, end, set, map, reverse);
    }
}
