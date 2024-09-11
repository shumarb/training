class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int minimumPriceSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minimumPriceSoFar) {
                minimumPriceSoFar = prices[i];
            } else if (prices[i] > minimumPriceSoFar) {
                maximumProfit = Math.max(maximumProfit, prices[i] - minimumPriceSoFar);
            }
        }

        return maximumProfit;
    }
}
