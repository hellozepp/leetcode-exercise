package leetcodeAll.leetcode;

/**
 * 27. Remove Element
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the
 * new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author Watcher
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		if (len == 1 && nums[0] == val)
			return 0;
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] != val)
				nums[index++] = nums[i];
		}
		return index;
	}
}
