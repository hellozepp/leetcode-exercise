package leetcodeAll.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] pre = new int[34];
        int[] cur = new int[34];
        pre[0] = pre[1] = cur[0] = cur[1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            cur = new int[34];
            cur[0] = cur[i] = 1;
            for (int j = 1; j < i; j++)
                cur[j] = pre[j - 1] + pre[j];
            pre = cur;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
            res.add(cur[i]);
        return res;
    }
}
