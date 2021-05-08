package hellozepp.math;


/**
 * 求 和为 n的 数相乘能组成的最大值
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * 难度2星
 */
public class Solution343 {

    /**
     * 思路
     * 可以看出如果3出现的次数越多越大
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;

        int sum = 1;
        while (n > 4) {

            n -= 3;
            sum *= 3;
        }

        return sum * n;
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
        System.out.println((new Solution343()).integerBreak(2));
        System.out.println((new Solution343()).integerBreak(10)); // 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
    }
}