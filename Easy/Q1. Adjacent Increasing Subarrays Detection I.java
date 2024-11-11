import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        // Check if input constraints are satisfied
        if (n < 2 * k) {
            return false;
        }

        // Iterate through the array to find two adjacent strictly increasing subarrays of length k
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to check if a subarray is strictly increasing
    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int length) {
        for (int i = start; i < start + length - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
