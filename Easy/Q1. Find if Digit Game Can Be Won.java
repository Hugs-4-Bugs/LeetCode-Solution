class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumSingleDigit = 0;
        int sumDoubleDigit = 0;
        int totalSum = 0;

        // Calculate the sum of single-digit and double-digit numbers
        for (int num : nums) {
            if (num < 10) {
                sumSingleDigit += num;
            } else {
                sumDoubleDigit += num;
            }
            totalSum += num;
        }

        // Check if Alice can win by choosing single-digit numbers
        if (sumSingleDigit > totalSum - sumSingleDigit) {
            return true;
        }

        // Check if Alice can win by choosing double-digit numbers
        if (sumDoubleDigit > totalSum - sumDoubleDigit) {
            return true;
        }

        return false;
    }
}
