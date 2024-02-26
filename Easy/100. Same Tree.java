class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //  Base case
//         if(p==null && q==null){
//             return true;
//         }
//         if(p==null || q==null){
//             return false;
//         }
//         if(p.val != q.val){
//             return false;
//         }
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }



// OR

if(p==null && q==null) return true;
if(p==null || q==null) return false;
return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val==q.val;
    }
}
