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




// Approach 1: Binary Search
// Time: O(n2)
// Space: O(h)


// class Solution {
//   public int kthSmallest(TreeNode root, int k) {
//     final int leftCount = countNodes(root.left);

//     if (leftCount == k - 1)
//       return root.val;
//     if (leftCount >= k)
//       return kthSmallest(root.left, k);
//     return kthSmallest(root.right, k - 1 - leftCount); // LeftCount < k
//   }

//   private int countNodes(TreeNode root) {
//     if (root == null)
//       return 0;
//     return 1 + countNodes(root.left) + countNodes(root.right);
//   }
// }








// Approach 2: Inorder Traversal
// Time: O(n)
// Space: O(h)


// class Solution {
//   public int kthSmallest(TreeNode root, int k) {
//     traverse(root, k);
//     return ans;
//   }

//   private int ans = -1;
//   private int rank = 0;

//   private void traverse(TreeNode root, int k) {
//     if (root == null)
//       return;

//     traverse(root.left, k);
//     if (++rank == k) {
//       ans = root.val;
//       return;
//     }
//     traverse(root.right, k);
//   }
// }








// Approach 3: Stack
// Time: O(n)
// Space: O(h)


class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();

    while (root != null) {
      stack.push(root);
      root = root.left;
    }

    for (int i = 0; i < k - 1; ++i) {
      root = stack.pop();
      root = root.right;
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    return stack.peek().val;
  }
}
