package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * @author Watcher
 *
 */
public class Sum3 {

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listAll = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return listAll;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int a = -nums[i];
				int j = i + 1, k = nums.length - 1;
				while (j < k) {
					if (nums[j] + nums[k] == a) {
						listAll.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1])
							j++;
						while (j < k && nums[k] == nums[k - 1])
							k--;
						j++;
						k--;
					} else if (nums[j] + nums[k] > a)
						k--;
					else {
						j++;
					}
				}
			}

		}
		return listAll;
	}
}
