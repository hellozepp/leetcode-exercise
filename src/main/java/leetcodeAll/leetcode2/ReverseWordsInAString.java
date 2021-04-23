package leetcodeAll.leetcode2;

/**
 * 151. Reverse Words in a String
 */
public class ReverseWordsInAString {

    /**
     * 耗时最短的解法
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int start = cs.length - 1, end = cs.length - 1;
        while (start >= 0) {
            if (cs[start] == ' ') {
                sb.append(s.substring(start + 1, end + 1)).append(' ');
                while (cs[start] == ' ')
                    start--;
                end = start;
            } else
                start--;
        }
        sb.append(s.substring(start + 1, end + 1));
        return sb.toString();
    }

    public String reverseWords4(String s) {
        if (s == null || s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i--)
            if (!ss[i].equals(" "))
                sb.append(ss[i]).append(' ');
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public String reverseWords3(String s) {
        s = s.trim();
        if (s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        char[] cs = sb.reverse().toString().toCharArray();
        int start = 0, end = 0;
        while (end < cs.length) {
            if (cs[end] == ' ') {
                reverse(cs, start, end - 1);
                for (int i = start; i <= end; i++)
                    res.append(cs[i]);
                while (cs[end] == ' ')
                    end++;
                start = end;
            } else
                end++;
        }
        reverse(cs, start, end - 1);
        for (int i = start; i < end; i++)
            res.append(cs[i]);
        return res.toString();
    }

    public String reverseWords2(String s) {
        s = s.trim();
        if (s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder(s);
        char[] cs = s.toCharArray();
        int index = 2;
        while (index < sb.length() - 1) {
            if (sb.charAt(index) == ' ' && sb.charAt(index - 1) == ' ') {
                sb.replace(index, index + 1, "");
                continue;
            }
            index++;
        }
        cs = sb.toString().toCharArray();
        reverse(cs, 0, cs.length - 1);
        int start = 0, end = 0;
        while (end < cs.length) {
            if (cs[end] == ' ') {
                reverse(cs, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverse(cs, start, end - 1);
        return new String(cs);
    }

    private void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char tmp = cs[start];
            cs[start++] = cs[end];
            cs[end--] = tmp;
        }
    }
}
