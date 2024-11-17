class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] decrementCount = new int[n+1];
        for(int[] query : queries){
            int li = query[0];
            int ri = query[1];
            decrementCount[li]++;
            if(ri+1 < n){
                decrementCount[ri+1]--;
            }
        } 
        for(int i=1; i<n; i++){
            decrementCount[i] += decrementCount[i-1];
        }

        for(int i=0; i<n; i++){
            if(nums[i] > decrementCount[i]){
                return false;
            }
        }
        return true;
    }
}
