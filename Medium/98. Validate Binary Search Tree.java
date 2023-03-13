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


// Approach 1: Recursive


// class Solution {
//   public boolean isValidBST(TreeNode root) {
//     return isValidBST(root, null, null);
//   }

//   private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
//     if (root == null)
//       return true;
//     if (minNode != null && root.val <= minNode.val)
//       return false;
//     if (maxNode != null && root.val >= maxNode.val)
//       return false;

//     return                                      //
//         isValidBST(root.left, minNode, root) && //
//         isValidBST(root.right, root, maxNode);
//   }
// }



// Approach 2: Iterative (stack)


class Solution {
  public boolean isValidBST(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode pred = null;

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (pred != null && pred.val >= root.val)
        return false;
      pred = root;
      root = root.right;
    }

    return true;
  }
}
