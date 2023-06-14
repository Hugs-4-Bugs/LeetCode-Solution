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




//  Recursive Approach


// class Solution {
//     private int minDiff = Integer.MAX_VALUE;
//     private Integer prevVal = null;
    
//     public int getMinimumDifference(TreeNode root) {
//         inorderTraversal(root);
//         return minDiff;
//     }
    
//     private void inorderTraversal(TreeNode node) {
//         if (node == null) {
//             return;
//         }
        
//         inorderTraversal(node.left);
        
//         if (prevVal != null) {
//             minDiff = Math.min(minDiff, Math.abs(node.val - prevVal));
//         }
        
//         prevVal = node.val;
        
//         inorderTraversal(node.right);
//     }
// }









// Iterative Approach


class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        Integer prevVal = null;
        int minDiff = Integer.MAX_VALUE;
        
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            if (prevVal != null) {
                minDiff = Math.min(minDiff, Math.abs(curr.val - prevVal));
            }
            
            prevVal = curr.val;
            curr = curr.right;
        }
        
        return minDiff;
    }
}
