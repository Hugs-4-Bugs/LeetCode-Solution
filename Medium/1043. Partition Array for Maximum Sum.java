class Solution {

    // Function to find the maximum sum after partitioning the array
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // n is the length of the array
        int n = arr.length;
        // dp array to store the maximum sum at each partition
        int[] dp = new int[n + 1];
      
        // Loop over the array elements
        for (int i = 1; i <= n; ++i) {
            // Initialize the maximum element in the current partition to zero
            int maxInPartition = 0;
            // Try all possible partitions of size up to k
            for (int j = i; j > Math.max(0, i - k); --j) {
                // Update the maximum element in this partition
                maxInPartition = Math.max(maxInPartition, arr[j - 1]);
                // Update dp[i] with the maximum sum using the maximum element times the size of the partition
                // and compare it with the existing value in dp[i] to keep the max sum at each partition
                dp[i] = Math.max(dp[i], dp[j - 1] + maxInPartition * (i - j + 1));
            }
        }
        // Return the maximum sum after partitioning
        return dp[n];
    }
}
