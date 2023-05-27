// Approach 1: Top-down



// class Solution {
//   public String stoneGameIII(int[] stoneValue) {
//     // dp[i] := max "relative score" Alice can make w/ stoneValue[i:]
//     dp = new int[stoneValue.length];
//     Arrays.fill(dp, Integer.MIN_VALUE);

//     final int score = stoneGameIII(stoneValue, 0);
//     return score > 0 ? "Alice" : score < 0 ? "Bob" : "Tie";
//   }

//   private int[] dp;

//   private int stoneGameIII(int[] stoneValue, int i) {
//     if (i == stoneValue.length)
//       return 0;
//     if (dp[i] > Integer.MIN_VALUE)
//       return dp[i];

//     int sum = 0;
//     for (int j = i; j < i + 3 && j < stoneValue.length; ++j) {
//       sum += stoneValue[j];
//       dp[i] = Math.max(dp[i], sum - stoneGameIII(stoneValue, j + 1));
//     }

//     return dp[i];
//   };
// }










// Approach 2: Bottom-up

class Solution {
  public String stoneGameIII(int[] stoneValue) {
    final int n = stoneValue.length;
    // dp[i] := max "relative score" Alice can make w/ stoneValue[i:]
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 0, n, Integer.MIN_VALUE / 2);

    for (int i = n - 1; i >= 0; --i) {
      int sum = 0;
      for (int j = i; j < i + 3 && j < n; ++j) {
        sum += stoneValue[j];
        dp[i] = Math.max(dp[i], sum - dp[j + 1]);
      }
    }

    final int score = dp[0];
    return score > 0 ? "Alice" : score < 0 ? "Bob" : "Tie";
  }
}
