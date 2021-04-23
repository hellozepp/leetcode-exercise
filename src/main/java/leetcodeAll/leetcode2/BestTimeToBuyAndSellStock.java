package leetcodeAll.leetcode2;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int min = prices[0], res = 0;
        for (int p : prices) {
            res = Math.max(res, p - min);
            min = Math.min(min, p);
        }
        return res;
    }
}
