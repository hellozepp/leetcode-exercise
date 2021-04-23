package leetcodeAll.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * @author Watcher
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 1)
			return 1;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
}
