package leetcodeAll.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        backtrack(res, new ArrayList<>(), s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < s.length(); i++) {
                String cur = s.substring(0, i + 1);
                if (isPalindrome(cur)) {
                    list.add(cur);
                    backtrack(res, list, s.substring(i + 1));
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        backtrack2(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack2(List<List<String>> res, List<String> list, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
        } else
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome2(s, index, i)) {
                    list.add(s.substring(index, i + 1));
                    backtrack2(res, list, s, i + 1);
                    list.remove(list.size() - 1);
                }
            }
    }

    private boolean isPalindrome2(String s, int left, int right) {
        if (left == right)
            return true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
