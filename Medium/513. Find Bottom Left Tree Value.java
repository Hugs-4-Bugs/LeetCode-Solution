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



// Find Bottom Left Tree Value(BFS).java



// public class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int left = -1;
//         while (!queue.isEmpty()) {
//             int curSize = queue.size();
//             for (int i = 0; i < curSize; i++) {
//                 TreeNode cur = queue.poll();
//                 if (i == 0) left = cur.val;
//                 if (cur.left != null) queue.offer(cur.left);
//                 if (cur.right != null) queue.offer(cur.right);
//             }
//         }
//         return left;
//     }
// }











// Find Bottom Left Tree Value(DFS).java


public class Solution {
    private int bottomLeftValue = -1;
    private int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        dfsHelper(root, 1);
        return bottomLeftValue;
    }
    
    private void dfsHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        
        if (depth > maxDepth) {
            //update the result;
            maxDepth = depth;
            bottomLeftValue = root.val;
        }
        dfsHelper(root.left, depth + 1);
        dfsHelper(root.right, depth + 1);
    }
}
