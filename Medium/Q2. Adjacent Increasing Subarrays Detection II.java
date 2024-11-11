import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();  // Get the size of the array (length of the input array)

        // Edge case: If there are fewer than 2 elements, no valid adjacent subarrays can exist
        if (n < 2) return 0;

        // Step 1: Precompute the length of the longest increasing subarray starting at each index
        int[] inc = new int[n];

        // Initialize the dp array: the last element is trivially an increasing subarray of length 1
        inc[n - 1] = 1;

        // Fill in the `inc` array
        for (int i = n - 2; i >= 0; i--) {  // Start from second last element
            // If the current element is smaller than the next one, extend the increasing subarray
            if (nums.get(i) < nums.get(i + 1)) {
                inc[i] = inc[i + 1] + 1;  // Extend the subarray length by 1
            } else {
                inc[i] = 1;  // If not, reset to 1 (subarray of length 1 starting at i)
            }
        }

        // Step 2: Use binary search to find the largest k such that two adjacent subarrays of length k exist
        int left = 1, right = n / 2;  // Binary search bounds: k starts at 1, and max length of subarrays is n / 2

        int maxK = 0;  // Variable to store the maximum value of k found


      /* `left = 1` and `right = n / 2` define the search range for the maximum possible length `k` of adjacent 
      increasing subarrays using binary search. `left = 1` is the minimum possible subarray length, while `right = n / 2` 
      ensures two subarrays of length `k` can fit in the list.

OR

     `left = 1` starts with the smallest possible subarray size, and `right = n / 2` limits the search to sizes that fit 
     two adjacent subarrays. It helps find the largest size `k` of increasing subarrays that can fit next to each other.
    */
        while (left <= right) {  // Perform binary search until left exceeds right
            int mid = left + (right - left) / 2;  // Calculate the middle value (current candidate for k)
            boolean found = false;  // Flag to check if two valid subarrays of length mid are found

            // Check for two adjacent increasing subarrays of length mid
            for (int i = 0; i <= n - 2 * mid; i++) {  // i goes up to n - 2 * mid to ensure space for both subarrays
                // Check if subarrays starting at i and i + mid have at least 'mid' increasing elements
                if (inc[i] >= mid && inc[i + mid] >= mid) {
                    found = true;  // If found, set the flag to true
                    break;  // No need to check further, exit the loop
                }
            }

            // If valid subarrays are found, increase 'left' to look for larger k values
            if (found) {
                maxK = mid;  // Update maxK with the current mid value
                left = mid + 1;  // Search for larger k
            } else {
                right = mid - 1;  // Search for smaller k
            }
        }

        // Return the maximum value of k found
        return maxK;
    }
}
