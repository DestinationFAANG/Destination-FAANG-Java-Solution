
// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/find-the-duplicate-number/

// Video Solution: https://www.youtube.com/watch?v=Lu3if4xOA1s

**************** Java Solution ***********************
public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        // Find the intersection point of the two runners
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // Find the "entrance" to the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
