class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int row = m - 1; // Start from the bottom row
        int col = 0;    // Start from the leftmost column
        
        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += n - col; // All numbers to the right are also negative
                row--;  // Move up to the previous row
            } else {
                col++;  // Move right to the next column
            }
        }
        
        return count;
    }
}
