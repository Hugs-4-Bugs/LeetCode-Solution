// **
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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



//  Approach 1: List
// Add the value to the list and create left and right part
// Time complexity O(n)
// Space complexity O(n)



// class Solution {
//     public TreeNode sortedListToBST(ListNode head) {
//         List<Integer> list = new ArrayList<>();
//         ListNode cur = head;
//         while(cur != null){
//             list.add(cur.val);
//             cur = cur.next;
//         }
//         return buildNode(list, 0, list.size() - 1);
//     }

//     public TreeNode buildNode(List<Integer> list, int lo, int hi){
//         if (lo > hi) return null;
//         int mid = lo + (hi - lo)/2;
//         TreeNode node = new TreeNode(list.get(mid));
//         node.left = buildNode(list, lo, mid - 1);
//         node.right = buildNode(list, mid + 1, hi);
//         return node;
//     }
// }





// Approach 2: asd




class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }
}

