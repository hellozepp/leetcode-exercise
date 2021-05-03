package hellozepp.string;


import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 题目描述：
 *
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串
 *
 * 难度2星
 *
 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("xxcxxaxc"));
    }


}