package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * 
 * @author Watcher
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		backtrack(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
		return res;
	}

	private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
		if (list.size() == nums.length)
			res.add(new ArrayList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
					continue;
				list.add(nums[i]);
				used[i] = true;
				backtrack(nums, res, list, used);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
	}
}
