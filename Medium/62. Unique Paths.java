// // Approach 1: 2D DP
// // Time: O(mn)
// // Space: O(mn)


// class Solution {
//   public int uniquePaths(int m, int n) {
//     // dp[i][j] := unique paths from (0, 0) to (i, j)
//     int[][] dp = new int[m][n];
//     Arrays.stream(dp).forEach(A -> Arrays.fill(A, 1));

//     for (int i = 1; i < m; ++i)
//       for (int j = 1; j < n; ++j)
//         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

//     return dp[m - 1][n - 1];
//   }
// }






// // Approach 2: 1D DP
// // Time: O(mn)
// // Space: O(n)


class Solution {
  public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < m; ++i)
      for (int j = 1; j < n; ++j)
        dp[j] += dp[j - 1];

    return dp[n - 1];
  }
}



