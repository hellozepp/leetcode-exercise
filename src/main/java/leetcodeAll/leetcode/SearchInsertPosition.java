package leetcodeAll.leetcode;

/**
 * 35. Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * @author Watcher
 *
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		// if (nums[0] >= target)
		// return 0;
		// int len = nums.length;
		// if (nums[len - 1] < target)
		// return len;
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return lo;
	}
}
