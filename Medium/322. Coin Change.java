// // Approach 1: Combinations
// // Time: O(∣coins∣∣amount∣)
// // Space: O(∣amount∣)


// class Solution {
//   public int coinChange(int[] coins, int amount) {
//     // dp[i] := fewest # of coins to make up i
//     int[] dp = new int[amount + 1];
//     Arrays.fill(dp, 1, dp.length, amount + 1);

//     for (final int coin : coins)
//       for (int i = coin; i <= amount; ++i)
//         dp[i] = Math.min(dp[i], dp[i - coin] + 1);

//     return dp[amount] == amount + 1 ? -1 : dp[amount];
//   }
// }








// // Approach 1: Permutation
// // Time: O(∣coins∣∣amount∣)
// // Space: O(∣amount∣)

class Solution {
  public int coinChange(int[] coins, int amount) {
    // dp[i] := fewest # of coins to make up i
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, 1, dp.length, amount + 1);

    for (int i = 1; i <= amount; ++i)
      for (final int coin : coins)
        if (coin <= i)
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
}
