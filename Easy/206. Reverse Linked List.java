/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode head) {
        // Method - 1
    
	// if (null == head || null == head.next) {
	// 	return head;
	// }
	// ListNode reversedHead = reverseList(head.next);
	// head.next.next = head;
	// head.next = null;
    // return reversedHead;





    // // Method - 2
        if (head == null) {
        return null;
    }

    ListNode node = head,
            prev = null,
            reversed = null;

    while (node != null) {
        final ListNode next = node.next;

        if (node.next == null) {
            reversed = node;
        }
        node.next = prev;
        prev = node;
        node = next;
    }

    return reversed;

    }
}
