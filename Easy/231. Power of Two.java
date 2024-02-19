class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false; // Any non-positive number cannot be a power of two
        }
        return (n & (n - 1)) == 0; // Check if only one bit is set in the binary representation of n
    }
}
