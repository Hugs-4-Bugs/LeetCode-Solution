// // Approach 1: BFS
// // Time: O(mn)
// // Space: O(mn)



// class Solution {
//   public List<List<Integer>> pacificAtlantic(int[][] heights) {
//     final int m = heights.length;
//     final int n = heights[0].length;
//     List<List<Integer>> ans = new ArrayList<>();
//     Queue<int[]> qP = new ArrayDeque<>();
//     Queue<int[]> qA = new ArrayDeque<>();
//     boolean[][] seenP = new boolean[m][n];
//     boolean[][] seenA = new boolean[m][n];

//     for (int i = 0; i < m; ++i) {
//       qP.offer(new int[] {i, 0});
//       qA.offer(new int[] {i, n - 1});
//       seenP[i][0] = true;
//       seenA[i][n - 1] = true;
//     }

//     for (int j = 0; j < n; ++j) {
//       qP.offer(new int[] {0, j});
//       qA.offer(new int[] {m - 1, j});
//       seenP[0][j] = true;
//       seenA[m - 1][j] = true;
//     }

//     bfs(heights, qP, seenP);
//     bfs(heights, qA, seenA);

//     for (int i = 0; i < m; ++i)
//       for (int j = 0; j < n; ++j)
//         if (seenP[i][j] && seenA[i][j])
//           ans.add(new ArrayList<>(Arrays.asList(i, j)));

//     return ans;
//   }

//   private static final int[] dirs = {0, 1, 0, -1, 0};

//   private void bfs(int[][] heights, Queue<int[]> q, boolean[][] seen) {
//     while (!q.isEmpty()) {
//       final int i = q.peek()[0];
//       final int j = q.poll()[1];
//       final int h = heights[i][j];
//       for (int k = 0; k < 4; ++k) {
//         final int x = i + dirs[k];
//         final int y = j + dirs[k + 1];
//         if (x < 0 || x == heights.length || y < 0 || y == heights[0].length)
//           continue;
//         if (seen[x][y] || heights[x][y] < h)
//           continue;
//         q.offer(new int[] {x, y});
//         seen[x][y] = true;
//       }
//     }
//   }
// }









 // Approach 1: DFS
// // Time: O(mn)
// // Space: O(mn)


class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    final int m = heights.length;
    final int n = heights[0].length;
    List<List<Integer>> ans = new ArrayList<>();
    boolean[][] seenP = new boolean[m][n];
    boolean[][] seenA = new boolean[m][n];

    for (int i = 0; i < m; ++i) {
      dfs(heights, i, 0, 0, seenP);
      dfs(heights, i, n - 1, 0, seenA);
    }

    for (int j = 0; j < n; ++j) {
      dfs(heights, 0, j, 0, seenP);
      dfs(heights, m - 1, j, 0, seenA);
    }

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        if (seenP[i][j] && seenA[i][j])
          ans.add(new ArrayList<>(Arrays.asList(i, j)));

    return ans;
  }

  private void dfs(final int[][] heights, int i, int j, int h, boolean[][] seen) {
    if (i < 0 || i == heights.length || j < 0 || j == heights[0].length)
      return;
    if (seen[i][j] || heights[i][j] < h)
      return;

    seen[i][j] = true;
    dfs(heights, i + 1, j, heights[i][j], seen);
    dfs(heights, i - 1, j, heights[i][j], seen);
    dfs(heights, i, j + 1, heights[i][j], seen);
    dfs(heights, i, j - 1, heights[i][j], seen);
  }
}
