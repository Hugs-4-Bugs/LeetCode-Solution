// // Approach 1: DFS



// class Solution {
//   public int numSimilarGroups(String[] A) {
//     int ans = 0;
//     boolean[] seen = new boolean[A.length];

//     for (int i = 0; i < A.length; ++i)
//       if (!seen[i]) {
//         dfs(A, i, seen);
//         ++ans;
//       }

//     return ans;
//   }

//   private void dfs(final String[] A, int i, boolean[] seen) {
//     seen[i] = true;
//     for (int j = 0; j < A.length; ++j)
//       if (!seen[j] && isSimilar(A[i], A[j]))
//         dfs(A, j, seen);
//   }

//   private boolean isSimilar(final String X, final String Y) {
//     int diff = 0;
//     for (int i = 0; i < X.length(); ++i)
//       if (X.charAt(i) != Y.charAt(i) && ++diff > 2)
//         return false;
//     return true;
//   }
// }








// Approach 2: UF




class UnionFind {
  public UnionFind(int n) {
    count = n;
    id = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; ++i)
      id[i] = i;
  }

  public void unionByRank(int u, int v) {
    final int i = find(u);
    final int j = find(v);
    if (i == j)
      return;
    if (rank[i] < rank[j]) {
      id[i] = id[j];
    } else if (rank[i] > rank[j]) {
      id[j] = id[i];
    } else {
      id[i] = id[j];
      ++rank[j];
    }
    --count;
  }

  public int getCount() {
    return count;
  }

  private int count;
  private int[] id;
  private int[] rank;

  private int find(int u) {
    return id[u] == u ? u : (id[u] = find(id[u]));
  }
}

class Solution {
  public int numSimilarGroups(String[] A) {
    UnionFind uf = new UnionFind(A.length);

    for (int i = 1; i < A.length; ++i)
      for (int j = 0; j < i; ++j)
        if (isSimilar(A[i], A[j]))
          uf.unionByRank(i, j);

    return uf.getCount();
  }

  private boolean isSimilar(final String X, final String Y) {
    int diff = 0;
    for (int i = 0; i < X.length(); ++i)
      if (X.charAt(i) != Y.charAt(i) && ++diff > 2)
        return false;
    return true;
  }
}
