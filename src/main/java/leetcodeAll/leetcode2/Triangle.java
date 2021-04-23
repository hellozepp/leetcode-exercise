package leetcodeAll.leetcode2;

import java.util.List;

/**
 * 120. Triangle
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            List<Integer> rowList = triangle.get(i);
            for (int j = 0; j <= i; j++)
                dp[j] = rowList.get(j) + Math.min(dp[j], dp[j + 1]);
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows];
        if (rows >= 1)
            dp[0] += triangle.get(0).get(0);
        if (rows >= 2) {
            dp[1] = dp[0] + triangle.get(1).get(1);
            dp[0] += triangle.get(1).get(0);
        }
        for (int i = 2; i < rows; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
            dp[0] += triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp)
            min = Math.min(min, num);
        return min;
    }
}
