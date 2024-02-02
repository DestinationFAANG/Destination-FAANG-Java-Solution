// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/sort-list/

// Video Solution: https://www.youtube.com/watch?v=7halZ77R55o

**************** Java Solution ***********************


public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = sortList(head); // sort the first half
        ListNode right = sortList(mid); // sort the second half

        // Merge the sorted halves
        return merge(left, right);
    }

    // Function to find the middle of the list
    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null; // Split the list into two halves
        return mid;
    }

    // Function to merge two sorted lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes of list1 or list2
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
