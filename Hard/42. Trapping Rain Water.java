
// Approach 1:  two-pointer approach

// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length <= 2) {
//             return 0;
//         }
        
//         int left = 0, right = height.length - 1;
//         int leftMax = 0, rightMax = 0;
//         int trappedWater = 0;
        
//         while (left < right) {
//             if (height[left] < height[right]) {
//                 if (height[left] >= leftMax) {
//                     leftMax = height[left];
//                 } else {
//                     trappedWater += leftMax - height[left];
//                 }
//                 left++;
//             } else {
//                 if (height[right] >= rightMax) {
//                     rightMax = height[right];
//                 } else {
//                     trappedWater += rightMax - height[right];
//                 }
//                 right--;
//             }
//         }
        
//         return trappedWater;
//     }
// }













// Approach 2: brute force



class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int trappedWater = 0;
        
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            
            int minMaxHeight = Math.min(leftMax, rightMax);
            if (minMaxHeight > height[i]) {
                trappedWater += minMaxHeight - height[i];
            }
        }
        
        return trappedWater;
    }
}
