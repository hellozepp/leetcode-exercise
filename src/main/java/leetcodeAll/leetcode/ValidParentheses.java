package leetcodeAll.leetcode;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Note that an empty string is also considered valid.
 * 
 * @author Watcher
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public boolean isValid2(String s) {
		if (s.length() % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<Character>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (stack.isEmpty())
				stack.push(cs[i]);
			else if (cs[i] == '(' || cs[i] == '{' || cs[i] == '[') {
				stack.push(cs[i]);
			} else {
				char pop = stack.peek();
				if ((pop == '(' && cs[i] == ')') || (pop == '{' && cs[i] == '}') || (pop == '[' && cs[i] == ']'))
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
}
