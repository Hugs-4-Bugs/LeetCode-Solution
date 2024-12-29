class Solution {
    public long numberOfSubsequences(int[] nums) {
        long res = 0;
        Map<Double, Long> dp = new HashMap<>();
        for (int r = nums.length - 3; r >= 4; r--) {
            for (int s = r + 2; s < nums.length; s++) {
                double ratio = nums[r] / (double) nums[s];
                dp.put(ratio, dp.getOrDefault(ratio, 0L) + 1L);
            }
            int q = r - 2;
            for (int p = 0; p < q - 1; p++) {
                double ratio = nums[q] / (double) nums[p];
                res += dp.getOrDefault(ratio, 0L);
            }
        }
        return res;
    }
}
