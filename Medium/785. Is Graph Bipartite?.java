// enum Color { kWhite, kRed, kGreen }

// class Solution {
//   public boolean isBipartite(int[][] graph) {
//     Color[] colors = new Color[graph.length];
//     Arrays.fill(colors, Color.kWhite);

//     for (int i = 0; i < graph.length; ++i) {
//       // Already colored, do nothing
//       if (colors[i] != Color.kWhite)
//         continue;
//       // colors[i] == Color.kWhite
//       colors[i] = Color.kRed; // Always paint w/ Color.kRed
//       // BFS
//       Queue<Integer> q = new ArrayDeque<>(Arrays.asList(i));
//       while (!q.isEmpty()) {
//         for (int sz = q.size(); sz > 0; --sz) {
//           final int u = q.poll();
//           for (final int v : graph[u]) {
//             if (colors[v] == colors[u])
//               return false;
//             if (colors[v] == Color.kWhite) {
//               colors[v] = colors[u] == Color.kRed ? Color.kGreen : Color.kRed;
//               q.offer(v);
//             }
//           }
//         }
//       }
//     }

//     return true;
//   }
// }















// enum Color { kWhite, kRed, kGreen }

// class Solution {
//   public boolean isBipartite(int[][] graph) {
//     Color[] colors = new Color[graph.length];
//     Arrays.fill(colors, Color.kWhite);

//     for (int i = 0; i < graph.length; ++i)
//       if (colors[i] == Color.kWhite && !isValidColor(graph, i, colors, Color.kRed))
//         return false;

//     return true;
//   }

//   private boolean isValidColor(int[][] graph, int u, Color[] colors, Color color) {
//     // The painted color should be same as the `color`
//     if (colors[u] != Color.kWhite)
//       return colors[u] == color;

//     colors[u] = color; // Always paint w/ `color`

//     // All children should have valid colors
//     for (final int v : graph[u])
//       if (!isValidColor(graph, v, colors, color == Color.kRed ? Color.kGreen : Color.kRed))
//         return false;

//     return true;
//   }
// }















class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) {
                return false;
            }
        }

        return true;
    }
}
