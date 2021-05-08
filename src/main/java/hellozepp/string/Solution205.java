package hellozepp.string;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 判断2个字符串结构是否相同
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * <p>
 * <p>
 * 难度1.5星 难度：简单
 */
public class Solution205 {


    /**
     * 思路 建立对应关系, 1个 map 解决
     *
     * 然后判断就可以了
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (!map.get(a).equals(b)) return false;
            } else {
                if (!map.containsValue(b)) map.put(a, b);
                else return false;
            }

        }

        return true;


    }

    public boolean isIsomorphic1(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(sMap.put(s.charAt(i), i), tMap.put(t.charAt(i), i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution205().isIsomorphic("egg", "add"));
        System.out.println(new Solution205().isIsomorphic("foo", "bar"));
        System.out.println(new Solution205().isIsomorphic("paper", "title"));
        System.out.println(new Solution205().isIsomorphic1("egg", "add"));
        System.out.println(new Solution205().isIsomorphic1("foo", "bar"));
        System.out.println(new Solution205().isIsomorphic1("paper", "title"));
    }

}