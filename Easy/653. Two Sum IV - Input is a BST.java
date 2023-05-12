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


// Approach 1 : Inorder  (LST, Root, RST)

// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         if (root == null) return false;
//         List<Integer> list = new ArrayList<>();
//         inorder(root, list);
//         int i = 0, j = list.size() - 1;
//         while (i < j) {
//             int sum = list.get(i) + list.get(j);
//             if (sum == k) return true;
//             else if (sum < k) i++;
//             else j--;
//         }
//         return false;
//     }
    
//     private void inorder(TreeNode root, List<Integer> list) {
//         if (root == null) return;
//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// }









// Approach 2 : HashMap instead of HashSet  TC(n) SC(n)

// class Solution {
//     boolean ans = false;
//     HashMap<Integer, Integer> hm = new HashMap<>();
    
//     public void dfs(TreeNode root , int k){
//         if(root==null) return;
//         if(hm.containsKey(k-root.val)) ans = true;
        
//         hm.putIfAbsent(root.val,1);
        
//         dfs(root.left, k);
//         dfs(root.right, k);
        
//         return;
//     }
//     public boolean findTarget(TreeNode root, int k) {
//         dfs(root, k);
//         return ans;
//     }
// }








// Approach 3 : Set


// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         return util(root, k, new HashSet<>());
//     }
    
//     private boolean util(TreeNode root, int k, Set<Integer> set) {
//         if(root==null) {
//             return false;
//         }
        
//         if(set.contains(k-root.val)) {
//             return true;
//         }
//         set.add(root.val);
//         return util(root.left, k, set)||util(root.right, k, set);
//     }
// }









// Approach 4 : Recursion


// class Solution {
//     Set<Integer> set = new HashSet<Integer>();
//     public boolean findTarget(TreeNode root, int k) {
//         if(root == null) return false;
//         if(set.contains(k-root.val)) return true;
//         set.add(root.val);
//         return findTarget(root.left, k) || findTarget(root.right, k);
//     }
// }









// Approach 5 

class Solution {
    private Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k){
        if(root == null){
            return false;
        }
        int val = root.val;
        if(set.contains(k-val)){
            return true;
        }
        set.add(val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
