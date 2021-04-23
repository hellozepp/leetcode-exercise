package leetcodeAll.leetcode;

/**
 * 58. Length of Last Word
 * 
 * @author Watcher
 *
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s.trim().isEmpty())
			return 0;
		s = s.trim();
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ')
				return res;
			res++;
		}
		return res;
	}

	public int lengthOfLastWord2(String s) {
		if (s.trim().isEmpty())
			return 0;
		String[] ss = s.trim().split(" ");
		return ss[ss.length - 1].length();
	}
}
