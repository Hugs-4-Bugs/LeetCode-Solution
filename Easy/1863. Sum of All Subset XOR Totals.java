class Solution {
    public int subsetXORSum(int[] nums) {
        int totalSum = 0;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            totalSum |= num;
        }
        return totalSum <<(nums.length - 1);
        
    }
}
