package leetcodeAll.leetcode2;

/**
 * 164. Maximum Gap
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int len = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, res = Integer.MIN_VALUE;
        int[] mins = new int[len + 1], maxs = new int[len + 1];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int diff = max - min;
        if (diff == 0)
            return 0;
        for (int num : nums) {
            int index = (int) ((num - min) * 1.0 / diff * len);
            mins[index] = mins[index] == 0 ? num : Math.min(mins[index], num);
            maxs[index] = Math.max(maxs[index], num);
        }
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++)
            if (mins[i] != 0) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        return res;
    }
}
