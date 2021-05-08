package hellozepp.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 * 找出 是否有　nums[i]= nums[j]  and  |i-j| <=k
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1], k = 3
 * 输出: true
 * 1
 * 2
 * 示例 2:
 *
 * 输入: [1,0,1,1], k = 1
 * 输出: true
 * 1
 * 2
 * 示例 3:
 *
 * 输入: [1,2,1], k = 0
 * 输出: false
 * 1
 * 2
 *
 * 难度1星
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 0, 1, 0, 0, 0, 1}, 5));
    }
}