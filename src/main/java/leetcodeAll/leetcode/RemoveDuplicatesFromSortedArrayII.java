package leetcodeAll.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * @author Watcher
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		}
		return i;
	}

	public int removeDuplicates3(int[] nums) {
		int lo = 0;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (flag)
					continue;
				else {
					nums[++lo] = nums[i];
					flag = true;
				}
			} else {
				nums[++lo] = nums[i];
				flag = false;
			}
		}
		return lo + 1;
	}

	public int removeDuplicates2(int[] nums) {
		int lo = 0;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[lo]) {
				if (flag)
					continue;
				else {
					swap(nums, ++lo, i);
					flag = true;
				}
			} else {
				swap(nums, ++lo, i);
				flag = false;
			}
		}
		return lo + 1;
	}

	private void swap(int[] nums, int lo, int i) {
		if (lo == i)
			return;
		nums[lo] = nums[lo] ^ nums[i];
		nums[i] = nums[lo] ^ nums[i];
		nums[lo] = nums[lo] ^ nums[i];
	}

}
