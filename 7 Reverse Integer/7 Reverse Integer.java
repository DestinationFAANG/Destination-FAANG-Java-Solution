// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/reverse-integer/

// Video Solution: https://www.youtube.com/watch?v=fZwClQfC3qU

**************** Java Solution ***********************
class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            // Extract the last digit
            int pop = x % 10;
            x /= 10;
            
            // Check for overflow before actually updating the reversed number
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;  // Overflow case
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;  // Underflow case
            }
            
            // Update the reversed number
            rev = rev * 10 + pop;
        }
        
        return rev;
    }
}
