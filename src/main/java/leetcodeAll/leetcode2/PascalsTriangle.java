package leetcodeAll.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 2; j < i; j++)
                list.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
