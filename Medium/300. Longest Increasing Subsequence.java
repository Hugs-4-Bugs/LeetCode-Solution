// Approach 1: 2D DP



// class Solution {
//   public int lengthOfLIS(int[] nums) {
//     if (nums.length == 0)
//       return 0;

//     // dp[i] := the length of LIS ending in nums[i]
//     int[] dp = new int[nums.length];
//     Arrays.fill(dp, 1);

//     for (int i = 1; i < nums.length; ++i)
//       for (int j = 0; j < i; ++j)
//         if (nums[j] < nums[i])
//           dp[i] = Math.max(dp[i], dp[j] + 1);

//     return Arrays.stream(dp).max().getAsInt();
//   }
// }








  // Approach 2: Binary Search


  class Solution {
  public int lengthOfLIS(int[] nums) {
    // tails[i] := the minimum tail of all the increasing subsequences having
    // length i + 1
    // It's easy to see that `tails` must be an increasing array.
    List<Integer> tails = new ArrayList<>();

    for (final int num : nums)
      if (tails.isEmpty() || num > tails.get(tails.size() - 1))
        tails.add(num);
      else
        tails.set(firstGreaterEqual(tails, num), num);

    return tails.size();
  }

  private int firstGreaterEqual(List<Integer> A, int target) {
    final int i = Collections.binarySearch(A, target);
    return i < 0 ? -i - 1 : i;
  }
}
