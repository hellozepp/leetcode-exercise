package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * 
 * 
 * @author Watcher
 *
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses so = new GenerateParentheses();
		System.out.println(so.generateParenthesis(2));

	}

	/**
	 * 耗时较多
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n == 0)
			list.add("");
		else
			for (int i = n - 1; i >= 0; i--) {
				List<String> insertSub = generateParenthesis(i);
				List<String> tailSub = generateParenthesis(n - 1 - i);
				for (String insert : insertSub)
					for (String tail : tailSub)
						list.add("(" + insert + ")" + tail);
			}
		return list;
	}

	/**
	 * 回溯版，较快
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis2(int n) {
		return backtrack(new ArrayList<String>(), new StringBuilder(), 0, 0, n);
	}

	private List<String> backtrack(List<String> list, StringBuilder str, int left, int right, int n) {
		if (left + right == n * 2)
			list.add(str.toString());
		if (left < n) {
			backtrack(list, str.append("("), left + 1, right, n);
			str.deleteCharAt(str.length() - 1);
		}
		if (right < left) {
			backtrack(list, str.append(")"), left, right + 1, n);
			str.deleteCharAt(str.length() - 1);
		}
		return list;
	}

}
