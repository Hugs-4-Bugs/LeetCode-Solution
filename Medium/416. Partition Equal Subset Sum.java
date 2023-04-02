// // Approach 1: 2D DP
// // Time : O(nk), where, k=Σ∣nums[i]∣/2
// // Space: O(nk)

// class Solution {
//   public boolean canPartition(int[] nums) {
//     final int sum = Arrays.stream(nums).sum();
//     if (sum % 2 == 1)
//       return false;
//     return knapsack(nums, sum / 2);
//   }

//   private boolean knapsack(int[] nums, int subsetSum) {
//     final int n = nums.length;
//     // dp[i][j] := true if j can be formed by nums[0..i)
//     boolean[][] dp = new boolean[n + 1][subsetSum + 1];
//     dp[0][0] = true;

//     for (int i = 1; i <= n; ++i) {
//       final int num = nums[i - 1];
//       for (int j = 0; j <= subsetSum; ++j)
//         if (j < num)
//           dp[i][j] = dp[i - 1][j];
//         else
//           dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
//     }

//     return dp[n][subsetSum];
//   }
// }









// Approach 2: 1D DP
// Time: O(nk)
// Space: O(k)

class Solution {
  public boolean canPartition(int[] nums) {
    final int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1)
      return false;

    return knapsack(nums, sum / 2);
  }

  private boolean knapsack(int[] nums, int subsetSum) {
    // dp[i] := true if i can be formed by nums so far
    boolean[] dp = new boolean[subsetSum + 1];
    dp[0] = true;

    for (final int num : nums)
      for (int i = subsetSum; i >= num; --i)
        dp[i] = dp[i] || dp[i - num];

    return dp[subsetSum];
  }
}
