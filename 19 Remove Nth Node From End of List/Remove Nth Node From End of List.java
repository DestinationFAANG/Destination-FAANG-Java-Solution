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

// LeetCode Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Youtube Solution Link: https://youtu.be/hZtAW3cp8vQ
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        
        ListNode front = dummy;
        ListNode back = dummy;
        
        for(int i=0; i<=n; i++){
            front = front.next;
        }
        
        while(front != null){
            front = front.next;
            back = back.next;
        }
        
        back.next = back.next.next;
        
        return dummy.next;
        
        
    }
}
