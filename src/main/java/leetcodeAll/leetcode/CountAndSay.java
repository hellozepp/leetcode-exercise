package leetcodeAll.leetcode;

/**
 * 38. Count and Say
 * 
 * @author Watcher
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
		return say(n - 1, "1");
	}

	private String say(int n, String str) {
		if (n == 0)
			return str;
		char[] cs = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == cs[i - 1])
				cnt++;
			else {
				sb.append(cnt).append(cs[i - 1]);
				cnt = 1;
			}
		}
		sb.append(cnt).append(cs[cs.length - 1]);
		return say(n - 1, sb.toString());
	}
}
