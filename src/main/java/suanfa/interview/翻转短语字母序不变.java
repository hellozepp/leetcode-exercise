package suanfa.interview;

public class 翻转短语字母序不变 {
    public static void main(String[] args) {
        String s = "i love you";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        String[] split = s.split("\\s");
        StringBuilder res = new StringBuilder();
        for (String s1 : split) {
            if (res.length() == 0) {
                res = new StringBuilder(reverse(s1));
            } else {
                res.append(" ").append(reverse(s1));
            }
        }
        return reverse(res.toString());
    }

    private static String reverse(String s1) {
        char[] chars = s1.toCharArray();
        int m = 0, n = chars.length - 1;
        while (m < n) {
            char tmp = chars[m];
            chars[m++] = chars[n];
            chars[n--] = tmp;
        }
        return String.valueOf(chars);
    }
}
