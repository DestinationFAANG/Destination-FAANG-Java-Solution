
// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/valid-parenthesis-string/

// Video Solution: hhttps://www.youtube.com/watch?v=h5YxPLC4lWs

**************** Java Solution ***********************

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum possible open parentheses
        int maxOpen = 0;  // Maximum possible open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Treat '(' as an open parenthesis
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                // Treat ')' as a closing parenthesis
                minOpen--;
                maxOpen--;
            } else {
                // '*' can be treated as '(', ')' or ""
                minOpen--;  // Treat '*' as ')'
                maxOpen++;  // Treat '*' as '('
            }
            
            // If at any point, maxOpen becomes negative, it means there are too many ')'
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen should never be negative, as we cannot have unmatched ')' without '('
            minOpen = Math.max(minOpen, 0);
        }
        
        // If minOpen is 0, it means all '(' can be matched with ')'
        return minOpen == 0;
    }

}
