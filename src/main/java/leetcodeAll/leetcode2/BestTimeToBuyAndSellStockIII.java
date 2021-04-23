package leetcodeAll.leetcode2;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int buy1 = Integer.MIN_VALUE, profit1 = 0;
        int buy2 = Integer.MIN_VALUE, profit2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -p);
            profit1 = Math.max(profit1, p + buy1);
            buy2 = Math.max(buy2, profit1 - p);
            profit2 = Math.max(profit2, p + buy2);
        }
        return profit2;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int res = 0, min = prices[0];
        int[] pre = new int[prices.length];
        int[] back = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            pre[i] = res;
            min = Math.min(min, prices[i]);
        }
        int max = prices[prices.length - 1];
        res = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            res = Math.max(res, max - prices[i]);
            back[i] = res;
            max = Math.max(max, prices[i]);
        }
        for (int i = 0; i < prices.length; i++)
            res = Math.max(res, pre[i] + back[i]);
        return res;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int res = 0;
        int[] dp = new int[prices.length + 1];
        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i + 1] = Math.max(dp[i + 1], prices[i] - prices[j]);
                res = Math.max(res, dp[i + 1] + dp[j]);
            }
        }
        return res;
    }
}
