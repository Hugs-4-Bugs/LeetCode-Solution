
public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n
        int[] temp = new int[n];

        // Copy elements to temporary array with rotation
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // Copy elements back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
    // public static void main(String[] args) {
    //     int[] nums = {1, 2, 3, 4, 5, 6, 7};
    //     int k = 3;
    //     rotate(nums, k);
    //     for (int num : nums) {
    //         System.out.print(num + " ");
    //     }
    // } 

}
