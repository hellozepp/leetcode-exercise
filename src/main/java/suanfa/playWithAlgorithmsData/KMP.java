package suanfa.playWithAlgorithmsData;

/**
 * 时间复杂度分析
 *
 * 设str1长度为n, str2的长度为m,
 *
 * Next数组的求取：为O(m)
 *
 * 总的时间复杂度为：O(n)
 */
public class KMP {
    public static int kmp(String str, String dest, int[] next) {//str文本串  dest 模式串
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }

    /**
     * 和kmp算法相同,都是比较重复位数,不同则取上一位的公共长度,相当于将模式串移动了(已匹配的字符数 - 前一位公共元素长度)
     * @param dest
     * @return
     */
    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //判断后继字符支持回退,不匹配找上一个字符的最长子串长度 j是匹配长度和匹配串的下标
            //j=3时 aba1 和 abab 比较->  j=2 ab & a1 -> j=1 a & 1 -> j=0 都不匹配
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //对初始字符的判断
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String a = "ababa1";//模式串
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);//生成最大前缀后缀公共元素长度表 001230
        int res = kmp(b, a, next);
        System.out.println(res);
        System.out.println("最大前缀后缀公共元素长度表---");
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        System.out.println(next.length);
    }
}