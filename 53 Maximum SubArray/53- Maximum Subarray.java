class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = 0;
        int maxNum = nums[0];
        
        for(int i=0; i<nums.length; i++){
                       
            if(currentSum < 0){
                currentSum = 0;
            }
            currentSum = currentSum+nums[i];
            maxNum = Math.max(maxNum, currentSum);
            
        }
        
        return maxNum;
        
    }
}