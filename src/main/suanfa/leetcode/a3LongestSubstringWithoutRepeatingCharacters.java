package suanfa.leetcode;

/**
 * 在一个字符串中寻找没有重复字母的最长子串，返回其长度。
 * 如”abcabcbb”，则结果为”abc”，长度为3
 * 如”bbbbb”，则结果为”b”，长度为1
 * 如”pwwkew”，则结果为”wke”，长度为3
 */
public class a3LongestSubstringWithoutRepeatingCharacters {

    protected int solution(char[] arr) {
        int[] freq = new int[256];
        int l = 0, r = -1, res = 0;
        while (l < arr.length) {
            if (r + 1 < arr.length && freq[arr[r + 1]] == 0) {
                freq[arr[++r]] = 1;
            } else {
                res = Math.max(res, r - l + 1);
                freq[arr[l++]] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcddbb";
        System.out.println(new a3LongestSubstringWithoutRepeatingCharacters().solution(s.toCharArray()));
    }
}
