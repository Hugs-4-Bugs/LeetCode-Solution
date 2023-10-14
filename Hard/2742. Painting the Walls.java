// Approach 1: Top-down



// class Solution {
//   public int paintWalls(int[] cost, int[] time) {
//     final int n = cost.length;
//     dp = new int[n][n + 1];
//     return paintWalls(cost, time, 0, time.length);
//   }

//   private static final int kMax = 500_000_000;
//   private int[][] dp;

//   private int paintWalls(int[] cost, int[] time, int i, int walls) {
//     if (walls <= 0)
//       return 0;
//     if (i == cost.length)
//       return kMax;
//     if (dp[i][walls] > 0)
//       return dp[i][walls];
//     final int pick = cost[i] + paintWalls(cost, time, i + 1, walls - time[i] - 1);
//     final int skip = paintWalls(cost, time, i + 1, walls);
//     return dp[i][walls] = Math.min(pick, skip);
//   }
// }















// Approach 2: Bottom-up


class Solution {
  public int paintWalls(int[] cost, int[] time) {
    final int kMax = 500_000_000;
    final int n = cost.length;
    // dp[i] := min cost to paint i walls by painters so far
    int[] dp = new int[n + 1];
    Arrays.fill(dp, kMax);
    dp[0] = 0;

    for (int i = 0; i < n; ++i)
      for (int walls = n; walls > 0; --walls)
        dp[walls] = Math.min(dp[walls], dp[Math.max(walls - time[i] - 1, 0)] + cost[i]);

    return dp[n];
  }
}
