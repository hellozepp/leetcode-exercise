package hellozepp.string;


/**
 * String转 int
 *
 * string 可能为任何情况
 *
 * 超过最大值 返回最大值
 *
 * 难度 2星
 *
 */
public class Solution8 {


    public int myAtoi(String str) {

        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();

        int start = 0;
        char first = str.charAt(0);

        int sign = 1;
        if (first == '+') {
            start++;

        }
        if (first == '-') {
            start++;
            sign = -1;
        }
        long sum = 0;


        for (int i = start; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }

            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }


        return (int) sum * sign;
    }

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.size(); r == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while (l < s.length()) {

            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
                freq[s.charAt(++r)]++;
            else    //r已经到头 || freq[s[r+1]] == 1
                freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}