package leetcodeAll.leetcode3;

/**
 * 214. Shortest Palindrome
 */
public class ShortestPalindrome {
    //-----------------solution1--------------2ms
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        char[] cs = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            cs[i] = s.charAt(i);
            cs[cs.length - i - 1] = s.charAt(i);
        }
        cs[s.length()] = '#';
        int[] next = new int[cs.length + 1];
        next[0] = -1;
        next[1] = 0;
        int cn = 0, pos = 2;
        while (pos < next.length) {
            if (cs[pos - 1] == cs[cn])
                next[pos++] = ++cn;
            else if (cn > 0)
                cn = next[cn];
            else
                next[pos++] = 0;
        }
        return new StringBuilder(s.substring(next[next.length - 1])).reverse().append(s).toString();
    }

    //----------------------solution2---------------2ms----
    public String shortestPalindrome2(String s) {
        if (s == null || s.length() < 2)
            return s;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse().insert(0, '#').insert(0, s);
        char[] cs = sb.toString().toCharArray();
        int[] next = new int[cs.length + 1];
        next[0] = -1;
        next[1] = 0;
        int cn = 0, pos = 2;
        while (pos < next.length) {
            if (cs[pos - 1] == cs[cn])
                next[pos++] = ++cn;
            else if (cn > 0)
                cn = next[cn];
            else
                next[pos++] = 0;
        }
        return new StringBuilder(s.substring(next[next.length - 1])).reverse().append(s).toString();
    }

    //----------------------solution3--------递归版----1ms-------
    public String shortestPalindrome3(String s) {
        int left = 0;
        for (int right = s.length() - 1; right >= 0; right--)
            if (s.charAt(left) == s.charAt(right))
                left++;
        if (left == s.length())
            return s;
        String suffix = s.substring(left);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome3(s.substring(0, left));
        return prefix + mid + suffix;
    }
}
