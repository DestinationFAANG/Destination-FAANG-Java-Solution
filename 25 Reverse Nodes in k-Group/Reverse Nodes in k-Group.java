
Most asked questions at FAANG: http://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

Leetcode URL: https://leetcode.com/problems/reverse-nodes-in-k-group/

Video Solution: https://github.com/DestinationFAANG/Destination-FAANG-Java-Solution

Java Solution: 

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode newHead = null;
        
        while(ptr != null){
            int count = 0;
            ptr = head;
            
            while(count<k && ptr!= null){
                ptr=ptr.next;
                count++;
            }
            if(count == k){
                ListNode revHead = reverseLinkedList(head,k);
                
                if(newHead == null){
                    newHead = revHead;
                }
                
                if(ktail != null){
                    ktail.next = revHead;
                }
                
                ktail = head;
                head = ptr;
            }
        }
        
        if(ktail != null){
            ktail.next = head;
        }
        
        return newHead == null ? head:newHead;
        
    }
    
    public ListNode reverseLinkedList(ListNode head, int k){
        
        ListNode newHead = null;
        ListNode ptr = head;
        
        while(k>0){
            
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            
            k--;
            
        }
        
        return newHead;
        
    }
}
