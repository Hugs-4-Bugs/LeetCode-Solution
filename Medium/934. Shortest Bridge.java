// Approach 1: Pure DFS


// class Solution {
//   public int shortestBridge(int[][] grid) {
//     markGridTwo(grid);

//     for (int color = 2;; ++color)
//       for (int i = 0; i < grid.length; ++i)
//         for (int j = 0; j < grid[0].length; ++j)
//           if (grid[i][j] == color)
//             if (expand(grid, i + 1, j, color) || expand(grid, i - 1, j, color) ||
//                 expand(grid, i, j + 1, color) || expand(grid, i, j - 1, color))
//               return color - 2;
//   }

//   // Marks one group to 2s by DFS.
//   private void markGridTwo(int[][] grid) {
//     for (int i = 0; i < grid.length; ++i)
//       for (int j = 0; j < grid[0].length; ++j)
//         if (grid[i][j] == 1) {
//           markGridTwo(grid, i, j);
//           return;
//         }
//   }

//   private void markGridTwo(int[][] grid, int i, int j) {
//     if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
//       return;
//     if (grid[i][j] != 1)
//       return;
//     grid[i][j] = 2;
//     markGridTwo(grid, i + 1, j);
//     markGridTwo(grid, i - 1, j);
//     markGridTwo(grid, i, j + 1);
//     markGridTwo(grid, i, j - 1);
//   }

//   // Returns true if we touch 1s' group through expanding.
//   private boolean expand(int[][] grid, int i, int j, int color) {
//     if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
//       return false;
//     if (grid[i][j] == 0)
//       grid[i][j] = color + 1;
//     return grid[i][j] == 1;
//   }
// }











// Approach 2: DFS + BFS

class Solution {
  public int shortestBridge(int[][] grid) {
    final int n = grid.length;
    final int[] dirs = {0, 1, 0, -1, 0};
    Queue<int[]> q = new ArrayDeque<>();

    markGridTwo(grid, q);

    // Expand by BFS.
    for (int ans = 0; !q.isEmpty(); ++ans)
      for (int sz = q.size(); sz > 0; --sz) {
        final int i = q.peek()[0];
        final int j = q.poll()[1];
        for (int k = 0; k < 4; ++k) {
          final int x = i + dirs[k];
          final int y = j + dirs[k + 1];
          if (x < 0 || x == n || y < 0 || y == n)
            continue;
          if (grid[x][y] == 2)
            continue;
          if (grid[x][y] == 1)
            return ans;
          grid[x][y] = 2;
          q.offer(new int[] {x, y});
        }
      }

    throw new IllegalArgumentException();
  }

  // Marks one group to 2s by DFS.
  private void markGridTwo(int[][] grid, Queue<int[]> q) {
    for (int i = 0; i < grid.length; ++i)
      for (int j = 0; j < grid[0].length; ++j)
        if (grid[i][j] == 1) {
          markGridTwo(grid, i, j, q);
          return;
        }
  }

  // Marks one group to 2s by DFS and push them to the queue.
  private void markGridTwo(int[][] grid, int i, int j, Queue<int[]> q) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
      return;
    if (grid[i][j] != 1)
      return;
    grid[i][j] = 2;
    q.offer(new int[] {i, j});
    markGridTwo(grid, i + 1, j, q);
    markGridTwo(grid, i - 1, j, q);
    markGridTwo(grid, i, j + 1, q);
    markGridTwo(grid, i, j - 1, q);
  }
}

