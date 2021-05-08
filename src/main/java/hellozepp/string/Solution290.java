package hellozepp.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * 难度2星
 *
 * FIXME
 */
public class Solution290 {


    public boolean wordPattern(String pattern, String str) {

        String[] strArry = str.split(" ");
        if (strArry.length != pattern.length()) return false;


        Map<String, Integer> map = new HashMap<>();
        for (Integer i = 0; i < strArry.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i) + "", i), map.put(strArry[i], i))) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>(); // 正向
        HashMap<String, Character> map2 = new HashMap<>(); // 反向
        String[] list = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != list.length) return false;

        for (int i = 0; i < list.length; i++) {
            if (map1.containsKey(chars[i]) && map2.containsKey(list[i])) { // 双向包含
                if (!map1.get(chars[i]).equals(list[i]) || map2.get(list[i]) != chars[i]) {
                    return false;
                }
            } else if (map1.containsKey(chars[i]) || map2.containsKey(list[i])) { // 单向包含
                return false;
            } else { // 双向均不包含
                map1.put(chars[i], list[i]);
                map2.put(list[i], chars[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<Character, String> map1 = new HashMap<>();
        System.out.println(map1.put('x', "y"));
        System.out.println(map1.put('x', "1"));
        System.out.println(map1.put('c', "y"));
        System.out.println("-------------");
        System.out.println("1," + new Solution290().wordPattern("abba", "dog cat cat dog"));
        System.out.println("2," + new Solution290().wordPattern("abba", "dog dat dat dog"));
        System.out.println("3," + new Solution290().wordPattern("abba", "doa cat cat dog")); //f
        System.out.println("4," + new Solution290().wordPattern("abba", "dog cat cat fish")); //f
        System.out.println("5," + new Solution290().wordPattern("abbc", "dog cat cat fish"));
        System.out.println("6," + new Solution290().wordPattern("aaaa", "dog cat cat dog")); //f
        System.out.println("-------------");
        System.out.println("1," + new Solution290().wordPattern1("abba", "dog cat cat dog"));
        System.out.println("2," + new Solution290().wordPattern1("abba", "dog dat dat dog"));
        System.out.println("3," + new Solution290().wordPattern1("abba", "doa cat cat dog")); //f
        System.out.println("4," + new Solution290().wordPattern1("abba", "dog cat cat fish")); //f
        System.out.println("5," + new Solution290().wordPattern1("abbc", "dog cat cat fish"));
        System.out.println("6," + new Solution290().wordPattern1("aaaa", "dog cat cat dog")); //f
    }
}