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
    public int pathSum(TreeNode root, int targetSum) {
        return helper(root,(long) targetSum, 0);
        
    }
    static int helper(TreeNode root, long targetSum, int count) {
        if (root == null) {
            return count;
        }
        count = dfs(root, targetSum, 0, count);
        count = helper(root.left, targetSum, count);
        count = helper(root.right, targetSum, count);


        return count;
    }

    static int dfs(TreeNode root, long targetSum, long sum, int count) {
        if (root == null) return count;
        sum += root.val;
        if (sum == targetSum) {
            ++count;
        }

        count = dfs(root.left, targetSum, sum, count);
        count = dfs(root.right, targetSum, sum, count);
        sum -= root.val;

        return count;


    }
}
