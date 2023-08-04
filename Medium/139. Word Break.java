// Approach 1: Top-down w/ raw string


class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
  }

  private boolean wordBreak(final String s, Set<String> wordSet, Map<String, Boolean> memo) {
    if (memo.containsKey(s))
      return memo.get(s);
    if (wordSet.contains(s)) {
      memo.put(s, true);
      return true;
    }

    // 1 <= prefix.length() < s.length()
    for (int i = 1; i < s.length(); ++i) {
      final String prefix = s.substring(0, i);
      final String suffix = s.substring(i);
      if (wordSet.contains(prefix) && wordBreak(suffix, wordSet, memo)) {
        memo.put(s, true);
        return true;
      }
    }

    memo.put(s, false);
    return false;
  }
}












// Approach 2: Top-down w/ index


// class Solution {
//   public boolean wordBreak(String s, List<String> wordDict) {
//     return wordBreak(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
//   }

//   // Returns true if s[i:] can be segmented.
//   private boolean wordBreak(final String s, int i, Set<String> wordSet, Boolean[] memo) {
//     if (i == s.length())
//       return true;
//     if (memo[i] != null)
//       return memo[i];

//     for (int j = i + 1; j <= s.length(); ++j)
//       if (wordSet.contains(s.substring(i, j)) && wordBreak(s, j, wordSet, memo))
//         return memo[i] = true;

//     return memo[i] = false;
//   }
// }










// Approach 3: Bottom-up

// class Solution {
//   public boolean wordBreak(String s, List<String> wordDict) {
//     final int n = s.length();
//     Set<String> wordSet = new HashSet<>(wordDict);
//     // dp[i] := true if s[0..i) can be segmented
//     boolean[] dp = new boolean[n + 1];
//     dp[0] = true;

//     for (int i = 1; i <= n; ++i)
//       for (int j = 0; j < i; ++j)
//         // s[0..j) can be segmented and s[j..i) in wordSet, so s[0..i) can be
//         // segmented
//         if (dp[j] && wordSet.contains(s.substring(j, i))) {
//           dp[i] = true;
//           break;
//         }

//     return dp[n];
//   }
// }











// Approach 4: Bottom-up (optimized)

// class Solution {
//   public boolean wordBreak(String s, List<String> wordDict) {
//     final int n = s.length();
//     final int maxLength = getMaxLength(wordDict);
//     Set<String> wordSet = new HashSet<>(wordDict);
//     // dp[i] := true if s[0..i) can be segmented
//     boolean[] dp = new boolean[n + 1];
//     dp[0] = true;

//     for (int i = 1; i <= n; ++i)
//       for (int j = i - 1; j >= 0; --j) {
//         if (i - j > maxLength)
//           break;
//         // s[0..j) can be segmented and s[j..i) in wordSet
//         // So s[0..i) can be segmented
//         if (dp[j] && wordSet.contains(s.substring(j, i))) {
//           dp[i] = true;
//           break;
//         }
//       }

//     return dp[n];
//   }

//   private int getMaxLength(List<String> wordDict) {
//     return wordDict.stream().mapToInt(String::length).max().getAsInt();
//   }
// }
