package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * 
 * @author Watcher
 *
 */
public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence so = new PermutationSequence();
		System.out.println(so.getPermutation(9, 101134));
	}

	public String getPermutation(int n, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int fact = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			fact *= i;
			list.add(i);
		}
		k--;
		for (int i = 1; i <= n; i++) {
			fact /= n - i + 1;
			int index = k / fact;
			sb.append(list.remove(index));
			k -= index * fact;
		}
		return sb.toString();
	}

	/**
	 * 递归，9ms
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation3(int n, int k) {
		if (n == 1)
			return "1";
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		n = getFact(n - 1);
		return getPerm(list, n, k);
	}

	private String getPerm(LinkedList<Integer> list, int fact, int k) {
		if (list.size() == 1)
			return list.get(0) + "";
		// int n = list.size();
		// int fact = getFact(n - 1);
		String s = list.remove((k - 1) / fact) + "";
		k = k - (k - 1) / fact * fact;
		s += getPerm(list, fact / list.size(), k);
		return s;
	}

	private int getFact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
	}

	/**
	 * 回溯，超时
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation2(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		return backtrack(n, k, res, new ArrayList<Integer>());
	}

	private String backtrack(int n, int k, List<List<Integer>> res, ArrayList<Integer> list) {
		if (list.size() == n) {
			res.add(new ArrayList<>(list));
			return null;
		}
		for (int i = 1; i <= n; i++) {
			if (list.contains(i))
				continue;
			list.add(i);
			backtrack(n, k, res, list);
			if (res.size() == k) {
				StringBuilder sb = new StringBuilder();
				for (Integer cur : res.get(k - 1))
					sb.append(cur);
				return sb.toString();
			}
			list.remove(list.size() - 1);
		}
		return null;
	}
}
