// // // Approach 1: DFS
// // Time: O(|V|+|E|), where |V| = numCourses and |E| = |prerequisites|
// // Space: O(|V|+|E|), where |V| = numCourses and |E| = |prerequisites|


// enum State { kInit, kVisiting, kVisited }

// class Solution {
//   public int[] findOrder(int numCourses, int[][] prerequisites) {
//     Deque<Integer> ans = new ArrayDeque<>();
//     List<Integer>[] graph = new List[numCourses];
//     State[] state = new State[numCourses];

//     for (int i = 0; i < numCourses; ++i)
//       graph[i] = new ArrayList<>();

//     for (int[] prerequisite : prerequisites) {
//       final int u = prerequisite[1];
//       final int v = prerequisite[0];
//       graph[u].add(v);
//     }

//     for (int i = 0; i < numCourses; ++i)
//       if (hasCycle(graph, i, state, ans))
//         return new int[] {};

//     return ans.stream().mapToInt(Integer::intValue).toArray();
//   }

//   private boolean hasCycle(List<Integer>[] graph, int u, State[] state, Deque<Integer> ans) {
//     if (state[u] == State.kVisiting)
//       return true;
//     if (state[u] == State.kVisited)
//       return false;

//     state[u] = State.kVisiting;
//     for (final int v : graph[u])
//       if (hasCycle(graph, v, state, ans))
//         return true;
//     state[u] = State.kVisited;
//     ans.addFirst(u);

//     return false;
//   }
// }








// Approach 2: Topology
// // Time: O(|V|+|E|)
// // Space: O(|V|+|E|)


class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer> ans = new ArrayList<>();
    List<Integer>[] graph = new List[numCourses];
    int[] inDegree = new int[numCourses];

    for (int i = 0; i < numCourses; ++i)
      graph[i] = new ArrayList<>();

    // Build graph
    for (int[] prerequisite : prerequisites) {
      final int u = prerequisite[1];
      final int v = prerequisite[0];
      graph[u].add(v);
      ++inDegree[v];
    }

    // Topology
    Queue<Integer> q = IntStream.range(0, numCourses)
                           .filter(i -> inDegree[i] == 0)
                           .boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));

    while (!q.isEmpty()) {
      final int u = q.poll();
      ans.add(u);
      for (final int v : graph[u])
        if (--inDegree[v] == 0)
          q.offer(v);
    }

    if (ans.size() == numCourses)
      return ans.stream().mapToInt(Integer::intValue).toArray();
    return new int[] {};
  }
}
