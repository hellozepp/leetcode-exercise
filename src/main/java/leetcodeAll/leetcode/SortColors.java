package leetcodeAll.leetcode;

/**
 * 75. Sort Colors
 * 
 * @author Watcher
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int less = -1, more = nums.length - 1, left = 0;
		while (left <= more) {
			if (nums[left] == 0)
				swap(nums, ++less, left++);
			else if (nums[left] == 1) {
				left++;
			} else
				swap(nums, left, more--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
}
