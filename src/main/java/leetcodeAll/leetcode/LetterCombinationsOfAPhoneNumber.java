package leetcodeAll.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * 
 * @author Watcher
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber so = new LetterCombinationsOfAPhoneNumber();
		/*
		 * List list = new LinkedList<String>(); list.add("a"); list.add("b"); list.add("c");
		 */
		// System.out.println(so.combination(new LinkedList<String>(), '3'));
		System.out.println(so.letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<String>();
		if (digits == null || digits.length() == 0)
			return list;
		char[] cs = digits.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			list = combination(list, cs[i]);
		}
		return list;
	}

	private List<String> combination(List<String> list, char ch) {
		char[][] nums = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 's', 'r' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		char[] cur = nums[ch - '0'];
		if (list.isEmpty()) {
			for (int i = 0; i < cur.length; i++)
				list.add(cur[i] + "");
			return list;
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String s = list.remove(0);
			for (int j = 0; j < cur.length; j++) {
				list.add(s + cur[j]);
			}
		}
		return list;
	}

}
