

public class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length < 2) {
            return profit;
        }
        int min = prices[0];
        
        

        
        for(int element : prices) {
            profit = Math.max(profit, element - min);
            if(min > element) {
                min = element;
            }
        }
        return profit;
        
    }
}
