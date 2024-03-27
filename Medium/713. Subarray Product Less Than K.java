class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       
       
       
    //     APPROACH 1 : Using Sliding Window




       
       
       
//        // Handle edge cases where k is 0 or 1 (no subarrays possible)
//         if(k <= 1)
//             return 0;

//         int totalCount = 0;
//         int product = 1;

// // Use two pointers to maintain a sliding window
//         for(int left = 0, right = 0; right<nums.length; right++){

//             // Expand the window by including the element at the right pointer
//             product *= nums[right];

//             // Shrink the window from the left while the product is greater than or equal to k
//             while(product >= k){

//             // Remove the element at the left pointer from the product
//             product /= nums[left++];

//             }
//         // Update the total count by adding the number of valid subarrays with the current window size
//             totalCount += right -left +1; // right - left + 1 represents the current window size

//         }
//         return totalCount;

























// APPROACH 2: Using Binary Search





 if (k == 0) return 0;
        double logK = Math.log(k);
        int m = nums.length + 1;
        double[] logsPrefixSum = new double[m];
        
        // Calculate prefix sum of logarithms of elements
        for (int i = 0; i < nums.length; i++) {
            logsPrefixSum[i + 1] = logsPrefixSum[i] + Math.log(nums[i]);
        }

        int totalCount = 0;
        // Calculate subarray count with product less than k
        for (int currIdx = 0; currIdx < m; currIdx++) {
            int low = currIdx + 1, high = m;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (logsPrefixSum[mid] < logsPrefixSum[currIdx] + logK - 1e-9) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            totalCount += low - currIdx - 1;
        }
        return totalCount;
        
    }
}
