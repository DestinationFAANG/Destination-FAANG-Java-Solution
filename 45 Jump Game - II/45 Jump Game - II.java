// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/jump-game-ii/

// Video Solution: https://www.youtube.com/watch?v=d_1GRnMg_zs

**************** Java Solution ***********************


class Solution {
    public int jump(int[] nums) {
        
        int jump=0, currMax = 0, currEnd = 0;
        
        for(int i=0; i<nums.length-1; i++){
            currMax = Math.max(currMax, i+nums[i]);
            if(i == currEnd){
                jump++;
                currEnd = currMax;
            }
        }
        
        return jump;
    }
}
