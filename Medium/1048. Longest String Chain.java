// Approach 1: Top-down

class Solution {
  public int longestStrChain(String[] words) {
    Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
    int ans = 0;

    for (final String word : words)
      ans = Math.max(ans, longestStrChain(word, wordsSet));

    return ans;
  }
  // dp[s] := longest string chain where s is the last word
  private Map<String, Integer> dp = new HashMap<>();

  private int longestStrChain(final String s, Set<String> wordsSet) {
    if (dp.containsKey(s))
      return dp.get(s);

    int ans = 1;

    for (int i = 0; i < s.length(); ++i) {
      final String pred = s.substring(0, i) + s.substring(i + 1);
      if (wordsSet.contains(pred))
        ans = Math.max(ans, longestStrChain(pred, wordsSet) + 1);
    }

    dp.put(s, ans);
    return ans;
  }
}












// Approach 2: Bottom-up


// class Solution {
//   public int longestStrChain(String[] words) {
//     int ans = 0;
//     Map<String, Integer> dp = new HashMap<>();

//     Arrays.sort(words, (a, b) -> a.length() - b.length());

//     for (final String word : words) {
//       int bestLength = 0;
//       for (int i = 0; i < word.length(); ++i) {
//         final String pred = word.substring(0, i) + word.substring(i + 1);
//         bestLength = Math.max(bestLength, dp.getOrDefault(pred, 0) + 1);
//       }
//       dp.put(word, bestLength);
//       ans = Math.max(ans, bestLength);
//     }

//     return ans;
//   }
// }
