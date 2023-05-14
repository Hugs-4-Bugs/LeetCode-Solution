class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int l = nums.length;
        for(int a=0;a<l;a++){
            if(nums[a]==val){
                continue;
            }
            nums[i] = nums[a];
            i++;
        }

        return i;
    }
}
