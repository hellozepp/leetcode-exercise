package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import others.Interval;

/**
 * 56. Merge Intervals
 * 
 * @author Watcher
 *
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		List<Interval> res = new ArrayList<>();
		int size = intervals.size();
		int[] starts = new int[size], ends = new int[size];
		for (int i = 0; i < size; i++) {
			Interval interval = intervals.get(i);
			starts[i] = interval.start;
			ends[i] = interval.end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		for (int i = 0, j = 0; i < size; i++) {
			if (i == size - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}

	public List<Interval> merge2(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		List<Interval> list = new ArrayList<>();
		Interval pre = intervals.get(0), cur = null;
		for (int i = 1; i < intervals.size(); i++) {
			cur = intervals.get(i);
			if (cur.start > pre.end)
				list.add(pre);
			else if (cur.end <= pre.end) {
				cur.start = pre.start;
				cur.end = pre.end;
			} else
				cur.start = pre.start;
			pre = cur;
		}
		list.add(cur);
		return list;
	}
}
