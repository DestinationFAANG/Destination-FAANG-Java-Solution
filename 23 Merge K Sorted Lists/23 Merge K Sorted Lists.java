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
// LeetCode Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/0
//Youtube Solution: https://youtu.be/SlKgDtpJnxg

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list: lists){
            while(list != null){
                minHeap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;
        
        while( !minHeap.isEmpty()){
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }
        
        return dummy.next;
        
    }
}
