package leetcodeAll.leetcode9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * * 870. Advantage Shuffle
 * 
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of
 * indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * @author Watcher
 *
 */
public class AdvantageShuffle {
	public static void main(String[] args) {
		int[] A = { 2, 7, 11, 15 };
		int[] B = { 1, 10, 4, 11 };
		System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(A, B)));
	}

	/**
	 * 最终版，使用优先级队列代替哈希表，效果更佳 可以提速20ms左右
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] advantageCount(int[] A, int[] B) {
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(10, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});
		int len = A.length;
		for (int i = 0; i < len; i++)
			queue.offer(new int[] { i, B[i] });
		Arrays.sort(A); // 对A排序
		int start = 0, end = len - 1;
		int[] res = new int[A.length];
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int bIndex = cur[0];
			int bVal = cur[1];
			if (A[end] > bVal)
				res[bIndex] = A[end--];
			else
				res[bIndex] = A[start++];
		}
		return res;
	}

	/**
	 * 初始版本，复杂度尚可，有待优化
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] advantageCount2(int[] A, int[] B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.length; i++)
			map.put(i, B[i]); // 存放B数组中值和下标，并根据值排序
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() { // 自定义比较器，对value排序
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

		int k = 0;
		while (k < A.length) {
			if (A[k] != -1) { // 找到第一个没有用过的A，放进res中，每放一个，list除去一个
				res[list.get(0).getKey()] = A[k]; // list中存放着尚未找到匹配的下标值，即res中未被赋值的下标
				list.remove(0);
			}
			k++;
		}

		return res;
	}
}
