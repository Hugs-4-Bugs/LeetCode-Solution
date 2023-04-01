// Approach 1: 1D DP
// Time: O(n)
// Space: O(n)


// class Solution {
//   public int rob(int[] nums) {
//     final int n = nums.length;
//     if (n == 0)
//       return 0;
//     if (n == 1)
//       return nums[0];

//     // dp[i] := max money of robbing nums[0..i]
//     int[] dp = new int[n];
//     dp[0] = nums[0];
//     dp[1] = Math.max(nums[0], nums[1]);

//     for (int i = 2; i < n; ++i)
//       dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

//     return dp[n - 1];
//   }
// }








//  Approach 2: O(1) DP
// Time: O(n)
// Space: O(1)


class Solution {
  public int rob(int[] nums) {
    int prev1 = 0; // dp[i - 1]
    int prev2 = 0; // dp[i - 2]

    for (final int num : nums) {
      final int dp = Math.max(prev1, prev2 + num);
      prev2 = prev1;
      prev1 = dp;
    }

    return prev1;
  }
}
