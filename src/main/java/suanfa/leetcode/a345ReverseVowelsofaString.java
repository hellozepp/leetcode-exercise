package suanfa.leetcode;

/**
 * 给定一个字符串，将该字符串中的元音字母翻转
 * 如：给出 ”hello”，返回”holle”
 * 如：给出“leetcode”，返回“leotcede”
 * 元音不包含y
 */
public class a345ReverseVowelsofaString {
    private static String solution(String str) {
        String vowels = "aeiouAEIOU";
        char[] chars = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            while (l < r && !vowels.contains(str.charAt(l) + "")) l++;
            while (l < r && !vowels.contains(str.charAt(r) + "")) r--;

            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);

    }

    public static void main(String[] args) {
        String a = "asdfgkle;";
        System.out.println(a);
        System.out.println(solution(a));
    }
}
