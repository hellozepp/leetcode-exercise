package hellozepp.dp;


/**
 * 找零钱，不能使用贪心，因为面值之间可能没有倍数规律，会导致使用大面值可能不如小面值张数少
 * 给出几种硬币 计算构成amount 的总少硬币数
 * 状态方程：dp[i] = getMin(dp[i - coins[j]]) + 1
 * 边界：i - coins[j]>=0 且 dp[i - coins[j]]！=-1
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * 难度2星
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int min;
        for (int i = 1; i <= amount; i++) {
            min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] + 1 < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}