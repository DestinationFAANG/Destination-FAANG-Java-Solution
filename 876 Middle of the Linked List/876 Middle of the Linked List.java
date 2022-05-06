//**************** Java Solution ***********************

//LeetCode Link: https://leetcode.com/problems/middle-of-the-linked-list/
// Youtube Link: https://www.youtube.com/watch?v=s7cHxJBuhjg


class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
