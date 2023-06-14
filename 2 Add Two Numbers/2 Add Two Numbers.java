Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

Leetcode Link: https://leetcode.com/problems/add-two-numbers/

Video Solution: https://www.youtube.com/watch?v=MYtp__JpTns

**************** Java Solution ***********************


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry+ x+y;
            
            carry = sum/10;
            
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            
        }
        
        return dummy.next;
        
    }
}


//test
