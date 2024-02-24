// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link:  https://leetcode.com/problems/longest-valid-parentheses/

// Video Solution: https://www.youtube.com/watch?v=GrSL3c8G6k8


**************** Java Solution ***********************

public class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for the next valid substring
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else {
                // Pop the top of the stack
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If stack is empty, push the current index as the base for the next valid substring
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
