package suanfa.playWithAlgorithmInterview.a343IntegerBreak.src;

/// 343. Integer Break
/// https://leetcode.com/problems/integer-break/description/

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */
public class Solution343 {
    private int[] memo;

    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than zero");
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    // 将n进行分割(至少分割两部分), 可以获得的最大乘积
    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    /**
     * /// 动态规划
     * /// 时间复杂度: O(n^2)
     * /// 空间复杂度: O(n)
     * @param n
     * @return
     */
    public int integerBreak3(int n) {

        if (n < 1)
            throw new IllegalArgumentException("n should be greater than zero");

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            // 求解memo[i]
            for (int j = 1; j <= i - 1; j++)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);

        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] memo = new int[10];
        System.out.println(JSON.toJSONString(memo));
        System.out.println((new Solution343()).integerBreak(2));
        System.out.println((new Solution343()).integerBreak(10));
        System.out.println((new Solution343()).integerBreak3(2));
        System.out.println((new Solution343()).integerBreak3(10));
    }
}
