package leetcodeAll.leetcode;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column.
 * 
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * 
 * @author Watcher
 *
 */
public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation so = new NextPermutation();
		int[] nums = { 1, 1 };
		so.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int index = nums.length - 2; // 从右到左第一个小于右边的数的下标
		while (index >= 0 && nums[index] >= nums[index + 1])
			index--;
		if (index >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[index])
				j--;
			swap(nums, index, j);
		}
		reverse(nums, index + 1);
	}

	public void nextPermutation2(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int index = nums.length - 2; // 从右到左第一个小于右边的数的下标
		for (; index >= 0; index--) {
			if (nums[index] < nums[index + 1])
				break;
		}
		if (index >= 0) {
			for (int j = nums.length - 1; j > index; j--) {
				if (nums[j] > nums[index]) {
					swap(nums, index, j);
					break;
				}
			}
		}
		reverse(nums, index + 1);
	}

	private void reverse(int[] nums, int i) {
		int j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
}
