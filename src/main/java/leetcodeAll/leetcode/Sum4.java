package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * 
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
 * nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the
 * sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * @author Watcher
 *
 */
public class Sum4 {

	/**
	 * You are here! Your runtime beats 100.00 % of java submissions.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> listAll = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return listAll;
		Arrays.sort(nums);
		for (int i = 0; i < len - 3; i++) {
			if (nums[i] * 4 > target)
				return listAll;
			if (nums[i] + nums[len - 1] * 3 < target)
				continue;
			if (i == 0 || nums[i] != nums[i - 1]) {
				for (int j = len - 1; j > i + 2; j--) {
					if (nums[i] + nums[j] * 3 < target)
						break;
					if (nums[i] * 3 + nums[j] > target)
						continue;
					if (j == len - 1 || nums[j] != nums[j + 1]) {
						int lo = i + 1, hi = j - 1;
						while (lo < hi) {
							if (nums[i] + nums[lo] + nums[hi] + nums[j] == target) {
								listAll.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
								while (lo < hi && nums[lo] == nums[lo + 1])
									lo++;
								while (lo < hi && nums[hi] == nums[hi - 1])
									hi--;
								lo++;
								hi--;
							} else if (nums[i] + nums[lo] + nums[hi] + nums[j] > target) {
								while (lo < hi && nums[hi] == nums[hi - 1])
									hi--;
								hi--;
							} else {
								while (lo < hi && nums[lo] == nums[lo + 1])
									lo++;
								lo++;
							}
						}
					}
				}
			}
		}
		return listAll;
	}
}
