package leetcodeAll.leetcode2;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1)
            return 0;
        if (prices.length <= k * 2) {
            int res = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1])
                    res += prices[i] - prices[i - 1];
            return res;
        }
        int[] buys = new int[k], profits = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        for (int p : prices) {
            for (int i = 0; i < k; i++) {
                buys[i] = Math.max(buys[i], (i == 0 ? 0 : profits[i - 1]) - p);
                profits[i] = Math.max(profits[i], p + buys[i]);
            }
        }
        return profits[k - 1];
    }
}
