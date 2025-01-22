import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        // Initialize the result height matrix with -1
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(height[i], -1);
        }

        // Directions for moving north, south, east, and west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j}); // Add the cell to the queue
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Visit all 4 neighboring cells
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the neighbor is within bounds and unvisited
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1; // Set height as current cell's height + 1
                    queue.offer(new int[]{nx, ny}); // Add the neighbor to the queue
                }
            }
        }

        return height; // Return the final height matrix
    }
}
