package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 2018.7.14周测
 * 
 * @author Watcher
 *
 */
public class Contest93 {

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in);
		 * 
		 * in.close();
		 */
		// System.out.println(new Contest93().binaryGap(8));
		// System.out.println(new Contest93().reorderedPowerOf2(1024));
		int[] B = { 13, 25, 32, 11 };
		int[] A = { 8, 12, 24, 32 };
		new Contest93().advantageCount(A, B);
	}

	/**
	 * 868. Binary Gap
	 * 
	 * Given a positive integer N, find and return the longest distance between two consecutive 1's in
	 * the binary representation of N.
	 * 
	 * If there aren't two consecutive 1's, return 0.
	 * 
	 * @param N
	 * @return
	 */
	public int binaryGap(int N) {
		int cnt = 0;
		int start = 0, end = 0;
		while (N > 0) {
			if ((N & 1) == 1) {
				// 当前位为1
				break;
			}
			N >>= 1;
			end++;
		}
		start = end;
		while (N > 0) {
			if ((N & 1) == 1) {
				// 当前位为1
				cnt = Math.max(cnt, end - start);
				start = end;

			}
			N >>= 1;
			end++;
		}
		return cnt;
	}

	/**
	 * 869. Reordered Power of 2
	 * 
	 * Starting with a positive integer N, we reorder the digits in any order (including the original
	 * order) such that the leading digit is not zero.
	 * 
	 * Return true if and only if we can do this in a way such that the resulting number is a power of
	 * 2.
	 * 
	 * 
	 * @param N
	 * @return
	 */
	public boolean reorderedPowerOf2(int N) {
		long n = N; // int逆序后有可能越界，用long接收

		n = change(n);
		long m = 1;
		while (n > change(m) || n > m) {
			m *= 2;
			if (n == change(m))
				return true;
		}
		return n == change(m);
	}

	/**
	 * 输入一个整数，输出由该数字构成的最大整数 123=>321
	 * 
	 * @param N
	 * @return
	 */
	private long change(long N) {
		char[] cs = (N + "").toCharArray();
		Arrays.sort(cs); // 先排序
		String ns = new StringBuilder(new String(cs)).reverse().toString(); // 再反转
		return Long.parseLong(ns);
	}

	/**
	 * 870. Advantage Shuffle
	 * 
	 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of
	 * indices i for which A[i] > B[i].
	 * 
	 * Return any permutation of A that maximizes its advantage with respect to B.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] advantageCount(int[] A, int[] B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.length; i++)
			map.put(i, B[i]); // 存放B数组中值和下标，并根据值排序
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() { // 自定义比价器，对value排序
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue() - o2.getValue();
			}
		});
		Arrays.sort(A); // 对A排序
		int[] res = new int[A.length];
		int i = A.length - 1;
		int j = i;
		while (j >= 0) {
			int bVal = list.get(j).getValue();
			int bIndex = list.get(j).getKey();
			if (A[i] > bVal) { // 从A的最大值开始匹配，找到第一个比A小的B的最大值
				res[bIndex] = A[i];
				A[i] = -1;
				list.remove(j); // 每匹配一个AB，list中除去相应的B的映射
				i--;
				j--;
			} else { // B大于A的话，再匹配更小的B值
				j--;
			}
		}

		if (list.isEmpty())
			return res; // list为空表示所有的B值都找到匹配的A值，直接返回res

		int l = 0;
		while (l < A.length) {
			if (A[l] != -1) { // 找到第一个没有用过的A，放进res中，每放一个，list除去一个
				res[list.get(0).getKey()] = A[l]; // list中存放着尚未找到匹配的下标值，即res中未被赋值的下标
				list.remove(0);
			}
			l++;
		}

		return res;
	}

}
