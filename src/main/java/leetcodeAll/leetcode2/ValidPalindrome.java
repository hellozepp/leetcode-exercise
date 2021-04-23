package leetcodeAll.leetcode2;

/**
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().isEmpty())
            return true;
        int start = 0, end = s.length() - 1;
        char[] cs = s.toLowerCase().toCharArray();
        while (start < end) {
            if (cs[start] < '0' || (cs[start] > '9' && cs[start] < 'a') || cs[start] > 'z') {
                start++;
                continue;
            }
            if (cs[end] < '0' || (cs[end] > '9' && cs[end] < 'a') || cs[end] > 'z') {
                end--;
                continue;
            }
            if (cs[start] == cs[end]) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }
}
