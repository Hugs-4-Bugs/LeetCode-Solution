class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int left = 0, right = queries.length;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canTransformToZero(nums, queries, mid)) {
                result = mid; // Found a valid k
                right = mid - 1; // Try for a smaller k
            } else {
                left = mid + 1; // Try for a larger k
            }
        }

        return result;
    }

    private boolean canTransformToZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] decrement = new int[n + 1]; // Use n + 1 for easier range handling

        // Simulate the first k queries using a difference array
        for (int i = 0; i < k; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            int vali = queries[i][2];
            decrement[li] += vali; // Start decrementing from li
            if (ri + 1 < n) {
                decrement[ri + 1] -= vali; // Stop decrementing after ri
            }
        }

        // Apply the difference array to get the actual decrements
        for (int i = 1; i < n; i++) {
            decrement[i] += decrement[i - 1];
        }

        // Check if we can make nums into a zero array
        for (int i = 0; i < n; i++) {
            if (nums[i] > decrement[i]) {
                return false; // Not enough decrements available
            }
        }

        return true; // All elements can be decremented to zero
    }
}
