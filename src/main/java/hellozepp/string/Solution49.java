package hellozepp.string;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 难度1星
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String pre = sort(str);
            map.computeIfAbsent(pre, k -> new ArrayList<>());
            map.get(pre).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String sort(String pre) {

        char[] temp = pre.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSON.toJSONString(new Solution49().groupAnagrams(arr)));
    }
}