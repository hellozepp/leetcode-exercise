package leetcodeAll.leetcode;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring.
 * 
 * @author Watcher
 *
 */
public class LongestValidParentheses {

	/**
	 * 动态规划解法
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		char[] ss = s.toCharArray();
		int len = ss.length;
		int[] dp = new int[len];
		if (ss[0] == '(' && ss[1] == ')')
			dp[1] = 2;
		int res = dp[1]; // 返回值
		for (int i = 2; i < len; i++) {
			char cur = ss[i];
			if (cur == '(')
				continue;
			if (cur == ')' && ss[i - 1] == '(')
				dp[i] = dp[i - 2] + 2;
			else if (cur == ')') {
				if (i - dp[i - 1] - 1 >= 0 && ss[i - dp[i - 1] - 1] == '(') {
					int before = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;
					dp[i] = dp[i - 1] + before + 2;
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	/**
	 * 用一个辅助栈，存放(的下标，辅助状态数组表示当前位置是否为合法的括号
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses2(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int res = 0; // 返回值
		int len = s.length();
		Stack<Integer> stack = new Stack<Integer>(); // 存放(
		int[] state = new int[len];
		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);
			if (cur == '(')
				stack.push(i);
			else if (!stack.isEmpty()) { // 当前为)，且栈中有(的下标
				state[i] = 1;
				state[stack.pop()] = 1;
			}
		}
		for (int i = 1; i < len; i++) {
			state[i] += state[i] * state[i - 1];
			res = Math.max(res, state[i]);
		}
		return res;
	}
}
