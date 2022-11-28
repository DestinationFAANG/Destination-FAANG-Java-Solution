// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/race-car/

// Video Solution: https://www.youtube.com/watch?v=TAXt_TkSNfw

**************** Java Solution ***********************


class Solution {
    public int racecar(int target) {
        
        int[] dp = new int[target+1];
        Arrays.fill(dp,1,dp.length, -1);
        
        return raceCar(target, dp);
        
   }
    
    public int raceCar(int target, int[] dp){
        
        if(dp[target] >= 0){
            return dp[target];
        }
        
        dp[target] = Integer.MAX_VALUE;
        
        int x = 1, j =1;
        
        for(; j<target; j=(1 << ++x)-1){
            for(int q=0, p=0; p<j; p=(1 << ++q) -1){
                dp[target] = Math.min(dp[target], x+1+1+q+raceCar(target-(j-p), dp));
            }
        }
        
        dp[target] = Math.min(dp[target], x+(target==j ? 0 : 1 + raceCar(j-target, dp)));
        
        return dp[target];
    }

}
