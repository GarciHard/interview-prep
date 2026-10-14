package com.garcihard.data_structures.array;

public class BestTimeToBuyAndSellStocks {

    public static int maxProfit(int[] prices) {
        int l = 0, r = 1, profit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int tmpProfit = prices[r] - prices[l];
                // We can also use Math.max()
                profit = tmpProfit > profit ? tmpProfit : profit;
            } else {
                l = r;
            }
            r++;
        }

        return profit;
    }
}
