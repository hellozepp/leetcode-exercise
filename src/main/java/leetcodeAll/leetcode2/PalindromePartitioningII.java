package leetcodeAll.leetcode2;

/**
 * 132. Palindrome Partitioning II
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int[] min = new int[s.length()];
        for (int i = 1; i < min.length; i++)
            min[i] = i;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            help(cs, i, i, min);
            help(cs, i, i + 1, min);
        }
        return min[min.length - 1];
    }

    private void help(char[] cs, int left, int right, int[] min) {
        while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
            if (left == 0)
                min[right] = 0;
            else
                min[right] = Math.min(min[right], min[left - 1] + 1);
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
        //String s = "aab";
        System.out.println(new PalindromePartitioningII().minCut(s));
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
        System.out.println(s.length());
    }
}
