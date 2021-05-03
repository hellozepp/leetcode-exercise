package suanfa.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串S和T，在S中寻找最短的子串，包含T中的所有字符
 * 如 S = “ADOBECODEBANC" ; T = "ABC"
 * 结果为 "BANC"
 * 要求时间复杂度是O(N)
 */
public class a76MinimumWindowSubstring {
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> freq = new HashMap<>(16);
        Map<Character, Integer> freqt = new HashMap<>(16);
        int l = 0, minLight = 0, minRight = 0, min = Integer.MAX_VALUE;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < tArr.length; ++i) {
            freq.compute(sArr[i], (k, val) -> val == null ? 1 : ++val);
            freqt.compute(tArr[i], (k, val) -> val == null ? 1 : ++val);
        }
        if (checkMinimumWindowSubstring(freq, freqt)) {
            min = tArr.length;
            minRight = tArr.length - 1;
        }
        for (int r = tArr.length; r < sArr.length; r++) {
            freq.compute(sArr[r], (k, val) -> val == null ? 1 : ++val);
            while (checkMinimumWindowSubstring(freq, freqt)) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    minRight = r;
                    minLight = l;
                }
                freq.put(sArr[l], freq.get(sArr[l]) - 1);
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minLight, minRight + 1);
    }

    private boolean checkMinimumWindowSubstring(Map<Character, Integer> freq, Map<Character, Integer> freqt) {
        for (Character c : freqt.keySet()) {
            if (freq.containsKey(c) && freq.get(c) >= freqt.get(c)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        //hashmap来统计t字符串中各个字母需要出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        //用来计数 判断当前子字符串中是否包含了t中全部字符
        int count = 0;
        //记录当前子字符串的左右下标值
        int left = 0;
        int right = 0;
        //记录当前最小子字符串的大小以及第一最后字符的下标值
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        for (; right < s.length(); right++) {
            char temp = s.charAt(right);
            if (map.containsKey(temp)) {//向后遍历出所包含t的字符串
                count = map.get(temp) > 0 ? count + 1 : count;
                map.put(temp, map.get(temp) - 1);
            }
            while (count == t.length()) {//得出一个符合条件的子字符串
                if (right - left < min) {//更新min minLeft minRight 信息
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                }
                char c = s.charAt(left);
                if (map.containsKey(c)) {//向左收缩 判断所删减的字符是否在map中
                    if (map.get(c) >= 0) {
                        count--;//count--时需要判断一下是否需要--
                    }
                    map.put(c, map.get(c) + 1);
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        System.out.println(new a76MinimumWindowSubstring().minWindow2("ADOBECODEBANC", "ABC"));
    }
}
