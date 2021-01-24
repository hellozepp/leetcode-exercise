package suanfa.leetcode;

/**
 *
 * 给定一个字符串，返回这个字符串的倒序字符串。
 *
 */
public class a344ReverseString {

    private static String reverse(String a) {
        char[] chars = a.toCharArray();
        StringBuilder b =new StringBuilder();
        for (int i=chars.length-1;i>=0;i--){
            b.append(chars[i]);
        }
        return b.toString();
    }
    public static void main(String[] args) {
        String a ="asdf12 3 4,";
        System.out.println(a);
        System.out.println(reverse(a));
    }

}
