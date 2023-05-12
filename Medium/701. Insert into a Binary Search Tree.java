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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode n = root;

        while (true) {
            if (val < n.val) {
                if (n.left != null) n = n.left;
                else {
                    n.left = new TreeNode(val);
                    break;
                }
            }
            else {
                if (n.right != null) n = n.right;
                else {
                    n.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}

// TC: O(logn), SC: O(1)
