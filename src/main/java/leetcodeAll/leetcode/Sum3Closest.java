package leetcodeAll.leetcode;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * 
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the threeintegers. You may assume that each input
 * would have exactly one solution.
 * 
 * @author Watcher
 *
 */
public class Sum3Closest {

	public static void main(String[] args) {
		int[] arr = { -1, -2, 1, 12, 5 };
		System.out.println(new Sum3Closest().threeSumClosest(arr, 5));
	}

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums); // 排序
		int diff = Integer.MAX_VALUE; // 差值
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int a = nums[i]; // 第一个数
				int j = i + 1, k = nums.length - 1; // 第二第三个数的索引
				while (j < k) {
					if (diff > Math.abs(a + nums[j] + nums[k] - target)) {
						diff = Math.abs(a + nums[j] + nums[k] - target);
						res = a + nums[j] + nums[k];
					}
					// diff = Math.min(diff, Math.abs(a + nums[j] + nums[k] - target));
					if (diff == 0)
						return res;
					else if (a + nums[j] + nums[k] > target) { // 大于target则大的向左移，并跳过重复的数
						while (j < k && nums[k] == nums[k - 1])
							k--;
						k--;
					} else {
						while (j < k && nums[j] == nums[j + 1]) // 小于target则小的向右移，并跳过重复的数
							j++;
						j++;
					}
				}
			}

		}
		return res;
	}
}
