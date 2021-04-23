package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * 
 * @author Watcher
 *
 */
public class TextJustification {

	public static void main(String[] args) {
		TextJustification so = new TextJustification();
		String[] words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is",
				"everything", "else", "we", "do" };
		System.out.println(so.fullJustify(words, 20));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int len = 0, start = 0;
		for (int i = 0; i < words.length; i++) {
			len += words[i].length() + 1;
			if (len - 1 > maxWidth) {
				joinWords(res, words, start, i - 1, maxWidth); // 下标start到i的单词形成组合
				start = i;
				len = words[i].length() + 1;
			}
		}
		joinWords(res, words, start, words.length - 1, maxWidth);
		return res;
	}

	private void joinWords(List<String> res, String[] words, int start, int end, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		if (start == end) { // 只有一个单词
			sb.append(words[start]);
			while (sb.length() < maxWidth)
				sb.append(' ');
			res.add(sb.toString());
		} else if (end == words.length - 1) { // 最后一行，且含有一个以上单词
			for (int i = start; i < end; i++)
				sb.append(words[i]).append(' ');
			sb.append(words[end]);
			while (sb.length() < maxWidth)
				sb.append(' ');
			res.add(sb.toString());
		} else {
			for (int i = start; i <= end; i++)
				maxWidth -= words[i].length();
			while (maxWidth > 0) {
				for (int i = start; i < end; i++) {
					words[i] += " ";
					maxWidth--;
					if (maxWidth == 0)
						break;
				}
			}
			for (int i = start; i <= end; i++)
				sb.append(words[i]);
			res.add(sb.toString());
		}
	}
}
