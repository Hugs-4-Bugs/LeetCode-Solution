// // Approach 1: Top-down

// class Solution {
//   public int longestPalindromeSubseq(String s) {
//     final int n = s.length();
//     // dp[i][j] := LPS's length in s[i..j]
//     dp = new int[n][n];
//     return lps(s, 0, n - 1);
//   }

//   private int[][] dp;

//   private int lps(final String s, int i, int j) {
//     if (i > j)
//       return 0;
//     if (i == j)
//       return 1;
//     if (dp[i][j] > 0)
//       return dp[i][j];

//     if (s.charAt(i) == s.charAt(j))
//       dp[i][j] = 2 + lps(s, i + 1, j - 1);
//     else
//       dp[i][j] = Math.max(lps(s, i + 1, j), lps(s, i, j - 1));

//     return dp[i][j];
//   }
// }








// Approach 2: Bottom-up


class Solution {
  public int longestPalindromeSubseq(String s) {
    final int n = s.length();
    // dp[i][j] := LPS's length in s[i..j]
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; ++i)
      dp[i][i] = 1;

    for (int d = 1; d < n; ++d)
      for (int i = 0; i + d < n; ++i) {
        final int j = i + d;
        if (s.charAt(i) == s.charAt(j))
          dp[i][j] = 2 + dp[i + 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
      }

    return dp[0][n - 1];
  }
}
