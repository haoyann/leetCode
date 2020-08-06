package jianzhioffer.step63;


public class Solution {
    public int maxProfit(int[] prices) {
        // dp[i] = max(dp[i-1],prices[i]-min)
        if(prices.length == 0){
            return  0;
        }
        int max = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            max = Math.max(max,prices[i]-min);
            if(min > prices[i]){
                min = prices[i];
            }
        }
        return max;


    }
}
