// Approach 1: Recursive

// class Solution {
//   public List<Integer> preorderTraversal(TreeNode root) {
//     List<Integer> ans = new ArrayList<>();
//     preorder(root, ans);
//     return ans;
//   }

//   private void preorder(TreeNode root, List<Integer> ans) {
//     if (root == null)
//       return;

//     ans.add(root.val);
//     preorder(root.left, ans);
//     preorder(root.right, ans);
//   }
// }








// Approach 2: Iterative


class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null)
      return new ArrayList<>();

    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      root = stack.pop();
      ans.add(root.val);
      if (root.right != null)
        stack.push(root.right);
      if (root.left != null)
        stack.push(root.left);
    }

    return ans;
  }
}


