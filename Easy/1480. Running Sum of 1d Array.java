class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length; 
        int[] sum = new int[n];
        if(n > 0)

        sum[0] = nums[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        return sum;
    }
}








// OR


// class Solution {
//     public int[] runningSum(int[] nums) {
//     int[] ans = new int[nums.length];
//     ans[0] = nums[0];
//     for (int i = 1; i < nums.length; i++)
//         ans[i] = ans[i-1] + nums[i];
//     return ans;
//     }
// }
