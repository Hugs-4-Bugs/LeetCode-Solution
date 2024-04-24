// Approach 1: Straightforward


// class Solution {
//   public int tribonacci(int n) {
//     if (n < 2)
//       return n;

//     int[] dp = {0, 1, 1};

//     for (int i = 3; i <= n; ++i) {
//       final int next = dp[0] + dp[1] + dp[2];
//       dp[0] = dp[1];
//       dp[1] = dp[2];
//       dp[2] = next;
//     }

//     return dp[2];
//   }
// }









// Approach 2: Concise

class Solution {
  public int tribonacci(int n) {
    int[] dp = {0, 1, 1};

    for (int i = 3; i <= n; ++i)
      dp[i % 3] = dp[0] + dp[1] + dp[2];

    return dp[n % 3];
  }
}
