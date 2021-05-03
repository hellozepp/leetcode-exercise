package suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s和一个非空字符串p，找出p中的所有是s的anagrams字符串的子串，返回这些子串的起始索引。
 * 字符串由小写的英文字母组成，字符串的长度和p的长度不会大于20100。
 * 输出的顺序无关紧要。
 * 如 s = "cbaebabacd" p = “abc”，返回[0, 6]
 * 如 s = "abab" p = “ba”，返回[0, 1, 2]
 * <p>
 * anagrams 连续的字符串且无序，等于p且是s的子集
 */
public class a438FindAllAnagramsInAString {

    private boolean check(int counter[], int tmp[]) {
        for (int i = 0; i < tmp.length; i++) {
            if (counter[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口+每滑动一次就检查一次
     * */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return res;
        }
        char S[] = s.toCharArray();
        char P[] = p.toCharArray();
        int counter[] = new int[26];
        int tmp[] = new int[26];
        for (char c : P) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < P.length; i++) {
            tmp[S[i] - 'a']++;
        }
        if (check(counter, tmp)) {
            res.add(0);
        }
        for (int i = P.length; i < S.length; i++) {
            tmp[S[i - P.length] - 'a']--;
            tmp[S[i] - 'a']++;
            if (check(counter, tmp)) {
                res.add(i - P.length + 1);
            }
        }
        return res;


    }

    public static void main(String[] args) {
        List<Integer> anagrams = new a438FindAllAnagramsInAString()
                .findAnagrams("cbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaeb" +
                                "abacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaebabac" +
                                "dcbaebabacdcbaebabacdabacdcbaebabacdcbaebabacdcbaebabacdcbaebabac" +
                                "dcbaebabacdcbaebabacdcbaebabacdcbaebabacdzxcvbnnmlkjhgfdsaqwertyuiop",
                        "abacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdcbaebabacd" +
                                "cbaebabacdcbaebabacdabacdcbaebabacdcbaebabacdcbaebabacdcbaeb" +
                                "abacdcbaebabacdcbaebabacdcbaebabacdcbaebabacdzxcvbnnmlkjhgfdsaqwertyuiop");
        System.out.println(anagrams.toString());
    }
}
