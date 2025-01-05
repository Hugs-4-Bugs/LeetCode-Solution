import java.util.Arrays;

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        // Iterate over all possible starting points of subarrays
        for (int start = 0; start < n; start++) {
            int prod = 1;
            int gcd = nums[start];
            int lcm = nums[start];

            // Iterate over all possible ending points of subarrays
            for (int end = start; end < n; end++) {
                prod *= nums[end];
                gcd = gcd(gcd, nums[end]);
                lcm = lcm(lcm, nums[end]);

                // Check if the current subarray is product equivalent
                if (prod == lcm * gcd) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }

    // Helper method to calculate GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to calculate LCM
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b; // LCM(a, b) = (a * b) / GCD(a, b)
    }
}
