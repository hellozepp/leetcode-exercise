package leetcodeAll.leetcode;

/**
 * 41. First Missing Positive
 * 
 * @author Watcher
 *
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive so = new FirstMissingPositive();
		int[] nums = { -1, 4, 2, 1, 9, 10 };
		System.out.println(so.firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
		}
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != i + 1)
				return i + 1;

		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
}
