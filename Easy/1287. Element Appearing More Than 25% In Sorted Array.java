class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        for (int i = 0; i < n - threshold; i++) {
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }
        
        return -1; // If no such element is found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 6, 6, 6, 6, 7, 10, 10, 10, 10};
    
    }
}
