package hellozepp.array;

import java.util.HashMap;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 时间复杂度 0（n）
 * 给出数组[100, 4, 200, 1, 3, 2]，这个最长的连续序列是 [1, 2, 3, 4]，返回所求长度 4
 *
 * 难度3星
 */
public class Solution128 {
    public int longestConsecutive(int[] num) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n - left, sum);
                map.put(n + right, sum);
                map.put(n, sum);
                // keep track of the max length
                res = Math.max(res, sum);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 2}));
    }
}