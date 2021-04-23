package leetcodeAll.leetcode;

/**
 * 53. Maximum Subarray
 * 
 * @author Watcher
 *
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int res = nums[0], sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			res = Math.max(res, sum);
			sum = sum < 0 ? 0 : sum;
		}
		return res;
	}

	public int maxSubArray2(int[] nums) {
		int res = nums[0], sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
				res = Math.max(res, sum);
				continue;
			}
			sum += nums[i];
			res = Math.max(res, sum);
		}
		return res;
	}
}
