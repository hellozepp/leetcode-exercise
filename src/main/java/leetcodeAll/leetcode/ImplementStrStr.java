package leetcodeAll.leetcode;

/**
 * 28. Implement strStr()
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * @author Watcher
 *
 */
public class ImplementStrStr {
	public static void main(String[] args) {
		ImplementStrStr so = new ImplementStrStr();
		System.out.println(so.strStr("aabba", "ba"));
		System.out.println("aabba".indexOf("asdasdasdas"));
	}

	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public int strStr2(String haystack, String needle) {
		if (needle.isEmpty() || haystack.equals(needle))
			return 0;
		int len1 = haystack.length(), len2 = needle.length();
		if (len1 < len2 || !haystack.contains(needle))
			return -1;
		if (len2 == 1)
			return haystack.indexOf(needle.toCharArray()[0]);

		for (int i = 0; i < len1 - len2 + 1; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				String tmp = haystack.substring(i, i + len2);
				if (tmp.equals(needle))
					return i;
			}
		}
		return -1;
	}

}
