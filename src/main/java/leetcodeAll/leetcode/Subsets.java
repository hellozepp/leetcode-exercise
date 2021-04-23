package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * 
 * @author Watcher
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null)
			return res;
		backtrack(res, new ArrayList<Integer>(), 0, nums);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> list, int index, int[] nums) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(res, list, i + 1, nums);
			list.remove(list.size() - 1);
		}
	}
}
