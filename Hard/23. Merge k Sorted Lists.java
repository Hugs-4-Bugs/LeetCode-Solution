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



//  Method1: Priority Queue: Use priority queue to select the minimum value.

	// class Solution {
	//     public ListNode mergeKLists(ListNode[] lists) {
	//         if(null == lists || lists.length == 0) return null;
	//         int len = lists.length;
	//         ListNode result = new ListNode(0);
	//         ListNode temp = result;
	//         PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, new Comparator<ListNode>(){
	//             @Override
	//             public int compare(ListNode v1, ListNode v2){
	//                 return v1.val - v2.val;
	//             }
	//         });
	//         for(ListNode node:lists){
	//             if(null != node)    queue.offer(node);
	//         }
	//         while(!queue.isEmpty()){
	//             ListNode node = queue.poll();
	//             if(null != node){
	//                 temp.next = node;
	//                 temp = temp.next;
	//                 if(node.next != null)   queue.offer(node.next);
	//             }
	//         }
	//         return result.next;
	//     }
	// }




    // Method2: Merge every two lists



	// class Solution {
	//     public ListNode mergeKLists(ListNode[] lists) {
	//         int len = lists.length;
	//         if(len == 0 )   return null;
	//         if(1 == len) return lists[0];
	//         ListNode result = new ListNode(0);
	//         result.next = lists[0];
	//         for(int i= 1; i < len; i++){
	//             result = mergeTwoList(result, lists[i]);
	//         }
	//         return result.next;
	//     }
	//     private ListNode mergeTwoList(ListNode result, ListNode mergeList){
	//         ListNode ans = new ListNode(0);
	//         ListNode dummy  = ans;
	//         ListNode head = new ListNode(0);
	//         head.next = mergeList;
	//         while(head.next != null || result.next != null){
	//             if(head.next != null && result.next != null){
	//                 if(head.next.val <= result.next.val){
	//                     ans.next = head.next;
	//                     head.next = head.next.next;
	//                 }else{
	//                     ans.next = result.next;
	//                     result.next = result.next.next;
	//                 }
	//                 ans = ans.next;
	//             }else if(head.next != null && result.next == null){
	//                 ans.next = head.next;
	//                 break;
	//             }else{
	//                 ans.next = result.next;
	//                 break;
	//             }
	//         }
	//         return dummy;
	//     }
	// }




// Method 3: Divide and conqur



 class Solution {
 	private ListNode[] l;
 	public ListNode mergeKLists(ListNode[] lists) {
 		if(lists.length == 0) return null;
 		else if(lists.length == 1) return lists[0];
 		this.l = lists;
 		return sort(0, this.l.length - 1);
 	}
 	private ListNode sort(int low, int high){
 		if(low >= high) return l[low];
 		int mid = low + (high - low) / 2;
 		ListNode l1 = sort(low, mid);
 		ListNode l2 = sort(mid + 1, high);
 		return merge(l1, l2);
 	}
 	private ListNode merge(ListNode l1, ListNode l2){
 		ListNode dummy = new ListNode(0), cur = dummy;
 		ListNode first = l1, second = l2;
 		while(first != null || second != null){
 			if(first != null && second != null){
 				cur.next = first.val < second.val ? first: second;
 				if(first.val < second.val) first = first.next;
 				else second = second.next;
 			}else if(first != null){
 				cur.next = first;
 				break;
 			}else{
 				cur.next = second;
 				break;
 			}
 			cur = cur.next;
 		}
 		return dummy.next;
 	}
 }
