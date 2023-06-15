/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// Approach 1: BFS
// TC = O(n),   SC = O(n)




// class Solution {
//   public int maxLevelSum(TreeNode root) {
//     int ans = 1;
//     int maxLevelSum = Integer.MIN_VALUE;
//     Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

//     for (int level = 1; !q.isEmpty(); ++level) {
//       int levelSum = 0;
//       for (int sz = q.size(); sz > 0; --sz) {
//         TreeNode node = q.poll();
//         levelSum += node.val;
//         if (node.left != null)
//           q.offer(node.left);
//         if (node.right != null)
//           q.offer(node.right);
//       }
//       if (maxLevelSum < levelSum) {
//         maxLevelSum = levelSum;
//         ans = level;
//       }
//     }

//     return ans;
//   }
// }











// Approach 2: DFS
// TC = O(n),   SC = O(h)


class Solution {
  public int maxLevelSum(TreeNode root) {
    // levelSums[i] := sum of level (i + 1) (1-indexed)
    List<Integer> levelSums = new ArrayList<>();
    dfs(root, 0, levelSums);
    return 1 + IntStream.range(0, levelSums.size())
                   .reduce(0, (a, b) -> levelSums.get(a) < levelSums.get(b) ? b : a);
  }

  private void dfs(TreeNode root, int level, List<Integer> levelSums) {
    if (root == null)
      return;
    if (levelSums.size() == level)
      levelSums.add(0);
    levelSums.set(level, levelSums.get(level) + root.val);
    dfs(root.left, level + 1, levelSums);
    dfs(root.right, level + 1, levelSums);
  }
}

