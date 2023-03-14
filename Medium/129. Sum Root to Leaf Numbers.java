class Solution {
    public int sumNumbers(TreeNode root) {
        return treePathsSumUtil(root, 0);
    }
    public int treePathsSumUtil (TreeNode node, int val){
        if (node == null) 
            return 0; 
        val = (val * 10 + node.val); 
        if (node.left == null && node.right == null) 
            return val; 
        return treePathsSumUtil(node.left, val) + treePathsSumUtil(node.right, val);
    }
}
