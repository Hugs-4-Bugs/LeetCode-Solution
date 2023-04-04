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


//  Approach 1: BFS


// class Solution {
//   public List<Integer> rightSideView(TreeNode root) {
//     if (root == null)
//       return new ArrayList<>();

//     List<Integer> ans = new ArrayList<>();
//     Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

//     while (!q.isEmpty()) {
//       final int size = q.size();
//       for (int i = 0; i < size; ++i) {
//         TreeNode node = q.poll();
//         if (i == size - 1)
//           ans.add(node.val);
//         if (node.left != null)
//           q.offer(node.left);
//         if (node.right != null)
//           q.offer(node.right);
//       }
//     }

//     return ans;
//   }
// }








// Approach 2: DFS



class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, 0, ans);
    return ans;
  }

  private void dfs(TreeNode root, int depth, List<Integer> ans) {
    if (root == null)
      return;

    if (depth == ans.size())
      ans.add(root.val);
    dfs(root.right, depth + 1, ans);
    dfs(root.left, depth + 1, ans);
  }
}
