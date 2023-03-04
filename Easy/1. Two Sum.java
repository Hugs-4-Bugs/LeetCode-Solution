class Solution {
    public int[] twoSum(int[] nums, int target) {
        int total; 
        //loop to check every element in the array
        for (int x = 0; x<nums.length; x++) {  
            total = target - nums[x];
            //loop to find total of current element
            for (int y = 0; y<nums.length; y++) { 
                //we cannot use same element twice.
                if (x ==  y) { continue; } 
                if (nums[y] == total) {
                    return new int[] {x, y};
                }
            }            
        }
        return new int[] {0, 0};
    }
}
