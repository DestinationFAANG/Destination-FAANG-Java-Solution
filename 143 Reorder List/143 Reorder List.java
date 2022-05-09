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

// LeetCode Link: https://leetcode.com/problems/reorder-list/
// Youtube Explaination: https://youtu.be/lBdS4AV1EGw
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null){
            return;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null, curr = slow, temp;
        
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode first = head, second = prev;
        
        while (second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
        
        
    }
}
