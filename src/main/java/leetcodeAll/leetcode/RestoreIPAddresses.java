package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * 
 * @author Watcher
 *
 */
@SuppressWarnings("unused")
public class RestoreIPAddresses {

	public static void main(String[] args) {
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("8888"));

	}

	List<String> res = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() < 4 || s.length() > 12)
			return res;
		// backtrack3(s.toCharArray(), new ArrayList<Integer>(), 0);
		backtrack(s.toCharArray(), new char[s.length() + 3], 0, 0);
		return res;
	}

	private void backtrack(char[] cs, char[] ip, int index, int cnt) {
		if (cnt == 4) {
			if (index != cs.length)
				return;
			res.add(new String(ip));
		} else {
			// 选取1、2、3个数作为当前位
			int num = 0;
			for (int i = index; i < index + 3 && i < cs.length; i++) {
				if (cs[index] == '0' && i > index)
					return;
				num = num * 10 + cs[i] - '0';
				if (num > 255)
					return;
				ip[i + cnt] = cs[i];
				if (cnt < 3)
					ip[i + cnt + 1] = '.';
				backtrack(cs, ip, i + 1, cnt + 1);
			}
		}
	}

	private void backtrack2(char[] cs, List<Integer> list, int index) {
		if (list.size() == 4) {
			if (index != cs.length)
				return;
			StringBuilder sb = new StringBuilder();
			for (Integer s : list)
				sb.append(s).append(".");
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
		} else {
			// 选取1、2、3个数作为当前位
			int num = 0;
			for (int i = index; i < index + 3 && i < cs.length; i++) {
				if (i > index && cs[index] == '0')
					return;
				num = num * 10 + cs[i] - '0';
				if (num > 255)
					return;
				list.add(num);
				backtrack2(cs, list, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private void backtrack3(char[] cs, List<Integer> list, int index) {
		if (index >= cs.length)
			return;
		if (list.size() == 3) {
			if (cs.length - index > 1 && cs[index] == '0' || cs.length - index > 3)
				return;
			int num = 0;
			for (int i = index; i < cs.length; i++)
				num = cs[i] - '0' + num * 10;
			if (num > 255)
				return;
			StringBuilder sb = new StringBuilder();
			for (Integer s : list)
				sb.append(s).append(".");
			sb.append(num);
			res.add(sb.toString());
		} else {
			// 选取1、2、3个数作为当前位
			int num = 0;
			for (int i = index; i < index + 3 && i < cs.length - 1; i++) {
				if (i > index && cs[index] == '0' || (cs.length - i - 1) / (4 - list.size()) > 3)
					return;
				// for (int j = index; j <= i; j++)
				num = num * 10 + cs[i] - '0';
				if (num > 255)
					return;
				list.add(num);
				backtrack3(cs, list, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

}
