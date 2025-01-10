// Using DP 

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int[] dp = new int[prices.length]; // dp[i] stores the max profit up to day i
        int minPrice = prices[0]; // Minimum price seen so far

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice); // Max profit if sold at day i
            minPrice = Math.min(minPrice, prices[i]); // Update minimum price
        }

        return dp[prices.length - 1]; // Maximum profit at the last day
    }
}






// O(n)

public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices == null || prices.length <=1 )return res;
        int min = prices[0];
        for(int i=1; i< prices.length; i++){
            if(prices[i] > min){
                res = Math.max(res, prices[i] - min);
            }else{
                min = prices[i];
            }
        }

        return res;

    }
}



class Solution {
	int maxProfit(int[] prices) {
	    int profit = 0, minPrice = Integer.MAX_VALUE;
		for(int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			profit = Math.max(profit, prices[i] - minPrice);
		}
		return profit;
	}
}



class Solution {
  public int maxProfit(int[] prices) {
    int sellOne = 0;
    int holdOne = Integer.MIN_VALUE;

    for (final int price : prices) {
      sellOne = Math.max(sellOne, holdOne + price);
      holdOne = Math.max(holdOne, -price);
    }

    return sellOne;
  }
}

