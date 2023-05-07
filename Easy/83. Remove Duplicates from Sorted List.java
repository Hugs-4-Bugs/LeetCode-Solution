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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode bucket = head;
        while (bucket != null && bucket.next != null)
        {
            if (bucket.next.val==bucket.val)
            {
                bucket.next=bucket.next.next;
                continue;
            }
            bucket=bucket.next;
        }
        return head;
    }
}
