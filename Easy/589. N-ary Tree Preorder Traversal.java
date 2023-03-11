/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// Approach 1

// class Solution {
//     List<Integer> ans = new ArrayList<>();
//     public List<Integer> preorder(Node root) {
//         if (root == null) return ans;
//         ans.add(root.val);
//         for (Node child : root.children)
//             preorder(child);
//         return ans;
//     }
// }




// Approach 2 : Recursive


// class Solution {
//     public void traversal(Node root, List<Integer>ans) {
//         if (root == null)
//             return;
//         ans.add(root.val);
//         for (Node child: root.children) 
//             traversal(child, ans);
// }
//     public List<Integer> preorder(Node root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         traversal(root, ans);
//         return ans;
//     }
// }




// Approach 3: Iterative




class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            ans.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                Node child = current.children.get(i);
                stack.push(child);
            }
        }
        return ans;
    }
}

