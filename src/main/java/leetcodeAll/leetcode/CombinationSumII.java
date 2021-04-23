package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * 
 * @author Watcher
 *
 */
public class CombinationSumII {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		if (candidates.length == 0 || target < candidates[0])
			return res;
		combination(candidates, target, 0, new ArrayList<Integer>());
		return res;
	}

	private void combination(int[] candidates, int target, int index, List<Integer> list) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			if (i > index && candidates[i] == candidates[i - 1])
				continue;
			list.add(candidates[i]);
			combination(candidates, target - candidates[i], i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}
