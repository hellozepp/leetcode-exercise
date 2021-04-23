package leetcodeAll.leetcode3;

/**
 * 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        int lo = 0, hi = 0;
        while (hi < nums.length) {
            if (sum < s)
                sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
