class Solution {
  public ListNode removeNodes(ListNode head) {
    if (head == null)
      return null;
    head.next = removeNodes(head.next);
    return head.next != null && head.val < head.next.val ? head.next : head;
  }
}




// OR

class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        
        ListNode nxt = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = nxt;
            nxt = cur;
        }
        
        return cur;
    }
}
