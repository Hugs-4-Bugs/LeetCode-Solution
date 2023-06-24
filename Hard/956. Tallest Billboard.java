// Approach 1: 2D DP

// class Solution {
//   public int tallestBillboard(int[] rods) {
//     final int n = rods.length;
//     final int sum = Arrays.stream(rods).sum();
//     // dp[i][j] := max min-height of using rods[0..i) to pile two piles that
//     // Have height difference j
//     int[][] dp = new int[n + 1][sum + 1];
//     Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
//     dp[0][0] = 0;

//     for (int i = 1; i <= n; ++i) {
//       final int h = rods[i - 1];
//       for (int j = 0; j <= sum - h; ++j) {
//         if (dp[i - 1][j] < 0)
//           continue;
//         // don't use rods[i - 1]
//         dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
//         // Put on the taller pile
//         dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]);
//         // Put on the shorter pile
//         dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(j, h));
//       }
//     }

//     return dp[n][0];
//   }
// }











// Approach 2: 1D DP


class Solution {
  public int tallestBillboard(int[] rods) {
    final int sum = Arrays.stream(rods).sum();
    // dp[i] := max min-height of using rods so far to pile two piles that have
    // Height difference i
    int[] dp = new int[sum + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (final int h : rods) {
      int[] prev = dp.clone();
      for (int i = 0; i <= sum - h; ++i) {
        if (prev[i] < 0)
          continue;
        // don't use this rod
        dp[i] = Math.max(dp[i], prev[i]);
        // Put on the taller pile
        dp[i + h] = Math.max(dp[i + h], prev[i]);
        // Put on the shorter pile
        dp[Math.abs(i - h)] = Math.max(dp[Math.abs(i - h)], prev[i] + Math.min(i, h));
      }
    }

    return dp[0];
  }
}

