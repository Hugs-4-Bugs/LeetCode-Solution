// // Approach 1: Stack
// // Time: O(∣ans∣)
// // Space: O(∣ans∣)



// class Solution {
//   public String decodeString(String s) {
//     Stack<Pair<StringBuilder, Integer>> stack = new Stack<>(); // (prevStr, repeatCount)
//     StringBuilder currStr = new StringBuilder();
//     int currNum = 0;

//     for (final char c : s.toCharArray())
//       if (Character.isDigit(c)) {
//         currNum = currNum * 10 + (c - '0');
//       } else {
//         if (c == '[') {
//           stack.push(new Pair<>(currStr, currNum));
//           currStr = new StringBuilder();
//           currNum = 0;
//         } else if (c == ']') {
//           final Pair<StringBuilder, Integer> pair = stack.pop();
//           final StringBuilder prevStr = pair.getKey();
//           final int n = pair.getValue();
//           currStr = prevStr.append(getRepeatedStr(currStr, n));
//         } else {
//           currStr.append(c);
//         }
//       }

//     return currStr.toString();
//   }

//   // S * n times
//   private StringBuilder getRepeatedStr(StringBuilder s, int n) {
//     StringBuilder sb = new StringBuilder();
//     while (n-- > 0)
//       sb.append(s);
//     return sb;
//   }
// }





// Approach 2: Recursive
// Time: O(∣ans∣)
// Space: O(∣ans∣)


class Solution {
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();

    while (i < s.length() && s.charAt(i) != ']')
      if (Character.isDigit(s.charAt(i))) {
        int k = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i)))
          k = k * 10 + (s.charAt(i++) - '0');
        ++i; // '['
        final String decodedString = decodeString(s);
        ++i; // ']'
        while (k-- > 0)
          sb.append(decodedString);
      } else {
        sb.append(s.charAt(i++));
      }

    return sb.toString();
  }

  private int i = 0;
}
