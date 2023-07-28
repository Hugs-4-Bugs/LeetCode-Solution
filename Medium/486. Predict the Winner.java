// Approach 1: 2D DP


class Solution {
  public boolean PredictTheWinner(int[] nums) {
    final int n = nums.length;
    // dp[i][j] := max number you can get more than your opponent in nums[i..j]
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; ++i)
      dp[i][i] = nums[i];

    for (int d = 1; d < n; ++d)
      for (int i = 0; i + d < n; ++i) {
        final int j = i + d;
        dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
      }

    return dp[0][n - 1] >= 0;
  }
}









// Approach 2: 1D DP

// class Solution {
//   public boolean PredictTheWinner(int[] nums) {
//     final int n = nums.length;
//     int[] dp = nums.clone();

//     for (int d = 1; d < n; ++d)
//       for (int j = n - 1; j - d >= 0; --j) {
//         final int i = j - d;
//         dp[j] = Math.max(nums[i] - dp[j],      // Pick left num
//                          nums[j] - dp[j - 1]); // Pick right num
//       }

//     return dp[n - 1] >= 0;
//   }
// }
