package suanfa.interview;

public class 循环移位字符串 {

    /**
     * @param args
     * 给几位数移动到末尾，时间on 空间o1
     */
    public static void main(String[] args) {
        String a = "abcdef";
        System.out.println( solution(a,2));
    }

    private static String solution(String s,int num) {
        String a =reverseStr(s,0,num-1);
        String b =reverseStr(a, num, s.length() - 1);
        return reverseStr(b,0,b.length()-1);
    }

    private static String reverseStr(String s, int m, int n) {
        char[] c = s.toCharArray();
        while (m < n) {
            char pre = c[n];
            c[n--] = c[m];
            c[m++] = pre;
        }
        return String.valueOf(c);
    }
}
