class Solution {
    public int longestOnes(int[] nums, int k) {

        int l=0; int r=0, max=0,n=nums.length;

        while(r<n){
            
            if(nums[r]==0) k--;

            while(k<0){//while is replacey by 'if' in next approach dry run to understand better
                if(nums[l]==0) k++;
                l++;                
            }
            max = Math.max(max,r-l+1);
            r++;
        }

        return max;
        
    }
}
