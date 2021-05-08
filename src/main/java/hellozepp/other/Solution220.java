package hellozepp.other;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * 判断数组中是否存在[ai aj] abs(ai - aj)<=t  && abs(i - j) <=k
 *
 * 难度3星
 *
 * FIXME
 *
 */
public class Solution220 {
    /**
     * 在LeetCode219——存在重复元素II的基础上，题目要求使得两元素差的绝对值最大为t，
     * 因此我们将hashMap改为treeMap结构存储，这样就可以用二分查找的速度来寻找到和
     * 某个新右端newNum匹配的最低值ceil。为了防止数据越界，改为Long类型来存储。
     *
     * 时间复杂度是O(nlogn)，其中n为数组的长度。空间复杂度是O(n)。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int left = 0;
        int right = -1;  //[left, right]为我们的滑动窗口
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        while (left < nums.length) {
            if (right + 1 < nums.length && right - left < k) {
                Long newNum = (long) nums[++right];
                Long ceil = treeMap.ceilingKey(-(long) t + newNum);
                if (ceil != null) {
                    if ((long) t + newNum >= ceil) {
                        return true;
                    }
                }
                if (treeMap.containsKey(newNum)) {
                    treeMap.put(newNum, treeMap.get(newNum) + 1);
                } else {
                    treeMap.put(newNum, 1);
                }
            } else {
                treeMap.put((long) nums[left], treeMap.get((long) nums[left]) - 1);
                if (treeMap.get((long) nums[left]) == 0) {
                    treeMap.remove((long) nums[left]);
                }
                left++;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}