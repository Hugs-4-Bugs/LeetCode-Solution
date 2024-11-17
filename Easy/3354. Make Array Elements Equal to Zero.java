class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;

        // Iterate over all possible starting positions where nums[curr] == 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // Try both directions: left (-1) and right (+1)
                if (isValidSelection(nums.clone(), i, -1)) {
                    count++;
                }
                if (isValidSelection(nums.clone(), i, 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValidSelection(int[] nums, int curr, int direction) {
        while (curr >= 0 && curr < nums.length) {
            if (nums[curr] == 0) {
                // Move in the current direction
                curr += direction;
            } else {
                // Decrement nums[curr] and reverse direction
                nums[curr]--;
                direction = -direction;
                curr += direction;
            }
        }

        // Check if all elements in nums are 0
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
