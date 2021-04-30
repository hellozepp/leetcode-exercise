package suanfa.leetcode;

/**
 * 给定一个字符串，只看其中的数字和字母，忽略大小写，判断这个字符串是否为回文串？
 */
public class a125ValidPalindrome {
    private static boolean solution(String str) {
        int l = 0;
        str = str.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
        int r = str.length() - 1;
        char[] arr = str.toCharArray();
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A12321 a";
        System.out.println(solution(str));
        ;
    }


}
