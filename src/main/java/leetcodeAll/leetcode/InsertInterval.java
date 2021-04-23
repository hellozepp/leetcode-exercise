package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import others.Interval;

/**
 * 57. Insert Interval
 * 
 * @author Watcher
 *
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		int size = intervals.size();
		for (int i = 0; i < size; i++) {
			Interval cur = intervals.get(i);
			if (cur.end < newInterval.start) {
				res.add(cur);
			} else if (cur.start > newInterval.end) {
				res.add(newInterval);
				newInterval = cur;
			} else {
				newInterval.start = Math.min(newInterval.start, cur.start);
				newInterval.end = Math.max(newInterval.end, cur.end);
			}
		}
		res.add(newInterval);
		return res;
	}

	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		int size = intervals.size();
		int[] starts = new int[size + 1], ends = new int[size + 1];
		for (int i = 0; i < size; i++) {
			Interval cur = intervals.get(i);
			starts[i] = cur.start;
			ends[i] = cur.end;
		}
		starts[size] = newInterval.start;
		ends[size] = newInterval.end;
		Arrays.sort(starts);
		Arrays.sort(ends);
		for (int i = 0, j = 0; i <= size; i++) {
			if (i == size || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
}
