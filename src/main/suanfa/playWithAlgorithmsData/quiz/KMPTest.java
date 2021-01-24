package suanfa.playWithAlgorithmsData.quiz;

public class KMPTest {
    public static void main(String[] args) {
        String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);//生成最大前缀后缀公共元素长度表
        int res = kmp(b, a, next);
        System.out.println(res);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        System.out.println(next.length);
    }

    private static int kmp(String str, String dest, int[] next) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (j > 0 && str.charAt(i) != dest.charAt(j)) {
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

    private static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        for (int i = 1, j = 0; i < dest.length(); i++) {
            if (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(j) == dest.charAt(i)) {
                j++;
            }
            next[j] = j;
        }
        return next;
    }


}
