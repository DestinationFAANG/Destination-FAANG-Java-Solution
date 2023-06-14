// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/regular-expression-matching/

// Video Solution: https://www.youtube.com/watch?v=VFQddcCP46c

**************** Java Solution ***********************


class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s == null || p == null){
            return false;
        }
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<p.length(); j++){
                
                if(p.charAt(j) =='.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }
                
                if(p.charAt(j) == '*'){
                    
                    if(p.charAt(j-1)!= s.charAt(i) && p.charAt(j-1)!= '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }    
                    
                    else{
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                        
                }
                
            }
        }
            
            return dp[s.length()][p.length()];
            
            
            
        }
}

//regular change
    
    
