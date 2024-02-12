// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/palindrome-linked-list/

// Video Solution: https://youtu.be/uGGAJxeXa4U

**************** Java Solution ***********************


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalfHead = reverse(slow.next);
        
        // Step 3: Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;
        while (p2 != null) { // Only need to compare the second half
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // Step 4: Restore the list (optional)
        slow.next = reverse(secondHalfHead);
        
        return isPalindrome;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
}
