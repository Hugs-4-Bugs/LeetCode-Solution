class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int operations = 0;

        // Iterate through each column
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                // If the current value is not greater than the previous value
                if (grid[i][j] <= grid[i - 1][j]) {
                    // Calculate the number of operations needed
                    int diff = grid[i - 1][j] - grid[i][j] + 1;
                    operations += diff;
                    // Update the grid to ensure the column is strictly increasing
                    grid[i][j] += diff;
                }
            }
        }
        
        return operations;
    }
}
