Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

Leetcode Link: https://leetcode.com/problems/first-missing-positive/

Video Solution: https://www.youtube.com/watch?v=N8DefKVUIKw

**************** Java Solution ***********************


class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        int contains = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                contains++;
                break;
            }
        }
        
        if(contains == 0){
            return 1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            int a= Math.abs(nums[i]);
            
            if(a==n){
                nums[0] = -Math.abs(nums[0]);
            }
            else{
                nums[a] = -Math.abs(nums[a]);
            }
        }
        
        
        for(int i = 1 ; i< n; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        
        
        if(nums[0] > 0){
            return n;
        }
        
        
        
        return n+1;
        
        
    }
}
