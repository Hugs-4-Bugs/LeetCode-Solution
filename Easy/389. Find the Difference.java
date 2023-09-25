// Approach 1: Bit

class Solution {
  public char findTheDifference(String s, String t) {
    char ans = 0;

    for (final char c : s.toCharArray())
      ans ^= c;

    for (final char c : t.toCharArray())
      ans ^= c;

    return ans;
  }
}







// Approach 2: Hash Table

// class Solution {
//   public char findTheDifference(String s, String t) {
//     int[] count = new int[128];

//     for (final char c : s.toCharArray())
//       ++count[c];

//     for (final char c : t.toCharArray())
//       if (--count[c] < 0)
//         return c;

//     throw new IllegalArgumentException();
//   }
// }
