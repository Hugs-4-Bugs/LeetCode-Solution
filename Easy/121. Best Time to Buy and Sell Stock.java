// // classic solution, will time limit exceeded. O(n^2)

// public class Solution {
//     public int maxProfit(int[] prices) {
//         int res = 0;
//         if(prices == null || prices.length <= 1) return res;
//         int[] dp = new int[prices.length];

//         dp[0] = 0;
//         for(int i=1; i<dp.length; i++){
//             for(int j=0; j<i; j++){
//                 dp[i] = Math.max(prices[i]-prices[j], dp[i]);
//             }
//             res = Math.max(dp[i], res);
//         }

//         return res;
//     }
// }





// O(n)

// public class Solution {
//     public int maxProfit(int[] prices) {
//         int res = 0;
//         if(prices == null || prices.length <=1 )return res;
//         int min = prices[0];
//         for(int i=1; i< prices.length; i++){
//             if(prices[i] > min){
//                 res = Math.max(res, prices[i] - min);
//             }else{
//                 min = prices[i];
//             }
//         }

//         return res;

//     }
// }



// class Solution {
// 	int maxProfit(int[] prices) {
// 	    int profit = 0, minPrice = Integer.MAX_VALUE;
// 		for(int i = 0; i < prices.length; i++) {
// 			minPrice = Math.min(minPrice, prices[i]);
// 			profit = Math.max(profit, prices[i] - minPrice);
// 		}
// 		return profit;
// 	}
// }



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

