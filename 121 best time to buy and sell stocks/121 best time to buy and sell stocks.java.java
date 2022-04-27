class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = 0;
        int sell = 1;
        int profit = 0;
        
        for (int i=1; i<prices.length; i++){
            
            profit = Math.max(profit, prices[sell]-prices[buy]);
            
            if (prices[sell] < prices[buy]){
                buy = sell;
            }
            sell++;
        }
        
        return profit;
    }
}