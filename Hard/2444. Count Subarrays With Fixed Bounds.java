class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
//          int count = 0;
//     for (int i = 0; i < nums.length; i++) {
//         for (int j = i; j < nums.length; j++) {
//             int min = Integer.MAX_VALUE;
//             int max = Integer.MIN_VALUE;
//             for (int k = i; k <= j; k++) {
//                 min = Math.min(min, nums[k]);
//                 max = Math.max(max, nums[k]);
//             }
//             if (min == minK && max == maxK) {
//                 count++;
//             }
//         }
//     }
//     return count;
//     }
// }



    long count = 0;
    int j = -1;
    int prevMinKIndex = -1;
    int prevMaxKIndex = -1;

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] < minK || nums[i] > maxK)
        j = i;
      if (nums[i] == minK)
        prevMinKIndex = i;
      if (nums[i] == maxK)
        prevMaxKIndex = i;
      // any index k in [j + 1, min(prevMinKIndex, prevMaxKIndex)] can be the
      // start of the subarray s.t. nums[k..i] satisfies the conditions
      count += Math.max(0, Math.min(prevMinKIndex, prevMaxKIndex) - j);
    }

    return count;
  }
}
