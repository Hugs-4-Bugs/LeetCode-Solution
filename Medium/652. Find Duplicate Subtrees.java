class Solution {
public:
    //怎么做？把每个结点的序列表示出来，再比较即可。用完全二叉树表示出来
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) 
    {
        vector<TreeNode*> res;
        unordered_map<string, int> m;
        helper(root, m, res);
        return res;
    }
    string helper(TreeNode* node, unordered_map<string, int>& m, vector<TreeNode*>& res) 
    {
        if (!node) return "#";
        string str = to_string(node->val) + "," + helper(node->left, m, res) + "," + helper(node->right, m, res);
        if (m[str] == 1) res.push_back(node);
        ++m[str];
        return str;
    }
};
