// Approach 1: DFS



class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty())
      return new ArrayList<>();

    List<String> ans = new ArrayList<>();

    dfs(digits, 0, new StringBuilder(), ans);
    return ans;
  }

  private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
                                                  "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
    if (i == digits.length()) {
      ans.add(sb.toString());
      return;
    }

    for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
      sb.append(c);
      dfs(digits, i + 1, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}












// Approach 2: Iterative

// class Solution {
//   public List<String> letterCombinations(String digits) {
//     if (digits.isEmpty())
//       return new ArrayList<>();

//     List<String> ans = new ArrayList<>();
//     ans.add("");
//     final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
//                                      "jkl", "mno", "pqrs", "tuv", "wxyz"};

//     for (final char d : digits.toCharArray()) {
//       List<String> temp = new ArrayList<>();
//       for (final String s : ans)
//         for (final char c : digitToLetters[d - '0'].toCharArray())
//           temp.add(s + c);
//       ans = temp;
//     }

//     return ans;
//   }
// }
