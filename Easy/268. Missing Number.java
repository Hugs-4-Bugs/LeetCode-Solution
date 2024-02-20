class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Calculate the sum of numbers from 0 to n
        int totalSum = (n * (n + 1)) / 2;
        
        // Calculate the sum of elements in the array
        int arraySum = 0;
         for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
        }
        
        // The missing number is the difference between the expected sum and the array sum
        return totalSum - arraySum;
    }
}
