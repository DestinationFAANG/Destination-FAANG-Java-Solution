//Leetcode Link: https://leetcode.com/problems/longest-palindromic-substring/
//Youtube Solution: https://www.youtube.com/watch?v=92KOT17h8zw

class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 1){
            return "";
        }
        int left = 0; int right = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > right - left){
                
                left = i-(len - 1)/2;
                right = i + len/2;
            }
        }
        
        return s.substring(left,right+1);
        
    }
    
    public int checkPalindrome(String s, int left, int right){
        
        int L = left, R = right;
        
        while(L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            
            L--;
            R++;
            
            
        }
        
        return R-L-1;
        
        
    }
}
