// Approach 1: Top-down


class Solution {
  public int strangePrinter(String s) {
    final int n = s.length();
    // dp[i][j] := min # of turns to print s[i..j]
    dp = new int[n][n];
    return strangePrinter(s, 0, n - 1);
  }

  private int[][] dp;

  private int strangePrinter(final String s, int i, int j) {
    if (i > j)
      return 0;
    if (dp[i][j] > 0)
      return dp[i][j];

    // Print s[i]
    dp[i][j] = strangePrinter(s, i + 1, j) + 1;

    for (int k = i + 1; k <= j; ++k)
      if (s.charAt(k) == s.charAt(i))
        dp[i][j] = Math.min(dp[i][j], strangePrinter(s, i, k - 1) + strangePrinter(s, k + 1, j));

    return dp[i][j];
  }
}











// Approach 2: Bottom-up


class Solution {
  public int strangePrinter(String s) {
    if (s.isEmpty())
      return 0;

    final int n = s.length();
    // dp[i][j] := min # of turns to print s[i..j]
    int[][] dp = new int[n][n];
    Arrays.stream(dp).forEach(row -> Arrays.fill(row, n));

    for (int i = 0; i < n; ++i)
      dp[i][i] = 1;

    for (int j = 0; j < n; ++j)
      for (int i = j; i >= 0; --i)
        for (int k = i; k < j; ++k)
          dp[i][j] =
              Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] - (s.charAt(k) == s.charAt(j) ? 1 : 0));

    return dp[0][n - 1];
  }
}

