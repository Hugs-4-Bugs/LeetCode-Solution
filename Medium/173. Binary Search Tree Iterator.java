// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// /**
//  * Your BSTIterator object will be instantiated and called as such:
//  * BSTIterator obj = new BSTIterator(root);
//  * int param_1 = obj.next();
//  * boolean param_2 = obj.hasNext();
//  */






// //  Approach 1: Recursive
// // Time: Constructor: O(n), next(): O(1), hasNext(): O(1)
// // Space: O(n)



// class BSTIterator {
//   public BSTIterator(TreeNode root) {
//     inorder(root);
//   }

//   /** @return the next smallest number */
//   public int next() {
//     return vals.get(i++);
//   }

//   /** @return whether we have a next smallest number */
//   public boolean hasNext() {
//     return i < vals.size();
//   }

//   private int i = 0;
//   private List<Integer> vals = new ArrayList<>();

//   private void inorder(TreeNode root) {
//     if (root == null)
//       return;

//     inorder(root.left);
//     vals.add(root.val);
//     inorder(root.right);
//   }
// }







// Approach 2: Iterative
// Time: Constructor: O(h), next(): O(h), hasNext(): O(1)
// Space: O(h)

class BSTIterator {
  public BSTIterator(TreeNode root) {
    pushLeftsUntilNull(root);
  }

  public int next() {
    TreeNode root = stack.pop();
    pushLeftsUntilNull(root.right);
    return root.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private Deque<TreeNode> stack = new ArrayDeque<>();

  private void pushLeftsUntilNull(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}
