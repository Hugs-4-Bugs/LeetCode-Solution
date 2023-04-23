// Approach #1 DFS
// Time: O(n * log10(k)) && Space: O(n)
// Explain: There are total n states, each state needs maximum log10(k) iteration loops to calculate the result.




// class Solution {
//     public int numberOfArrays(String s, int k) {
//         int[] memo = new int[s.length()];
//         Arrays.fill(memo, -1);
//         return dfs(s, k, memo, 0);
//     }

//     private int dfs(String s, int k, int[] memo, int i) {
//         if (i == s.length()) return 1;
//         if (s.charAt(i) == '0') return 0;
//         if (memo[i] != -1)   return memo[i];

//         int ans = 0;
//         long num = 0;
//         for (int j = i; j < s.length(); j++) {
//             num = num * 10 + s.charAt(j) - '0';
//             if (num > k) break;
//             ans += dfs(s, k, memo, j + 1);
//             ans %= 1000_000_007;
//         }

//         memo[i] = ans;
//         return ans;
//     }
// }










// Approach #2 DP
// Time: O(n log k) Space: O(n)
class Solution {
    int mod = (int)1e9 + 7;
    public int numberOfArrays(String s, int k) {
        if (s == null || s.length() == 0)     return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // initial 
        for (int i = n - 1; i >= 0; i--) {
            long num = s.charAt(i) - '0'; // long
            if (num != 0) {
                for (int j = i + 1; j <= n; j++) {
                    if (num > k)    break;
                    dp[i] = (dp[i] + dp[j]) % mod;
                    if (j < n) {
                        num = num * 10 + s.charAt(j) - '0';
                    }
                }
            } else {
                dp[i] = 0;
            }
        }

        return dp[0];
    }
}
