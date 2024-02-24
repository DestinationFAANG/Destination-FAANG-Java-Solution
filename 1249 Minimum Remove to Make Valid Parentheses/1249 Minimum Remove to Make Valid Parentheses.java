// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link:  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

// Video Solution: https://www.youtube.com/watch?v=h9skhJ_UZQo

**************** Java Solution ***********************

public class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    removeIndices.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        // Add remaining unmatched opening parentheses indices to the set
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }
        
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
