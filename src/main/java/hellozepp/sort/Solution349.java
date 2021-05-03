package hellozepp.sort;


import java.util.HashSet;
import java.util.Set;

/**
 * 返回 2个数组交集数字不重复
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 顺序可以任意
 * 结果中每个元素只能出现一次
 * 难度1星
 */
public class Solution349 {


    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n)) {
                intersect.add(n);
            }
        }

        int[] rst = new int[intersect.size()];

        int j = 0;
        for (int n : intersect) {
            rst[j++] = n;
        }

        return rst;

    }


}