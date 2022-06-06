//LeetCode Link: https://leetcode.com/problems/valid-parentheses/
// Youtube Solution: https://www.youtube.com/watch?v=D4l9TK0tWcI

class Solution {
     
    public boolean isValid(String s) {
        
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        
        mappedBrackets.put(')','(');
        mappedBrackets.put('}','{');
        mappedBrackets.put(']','[');
        
        Stack<Character>  stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(!mappedBrackets.containsKey(c)){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char topElement = stack.pop();
                if(topElement != mappedBrackets.get(c)){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
