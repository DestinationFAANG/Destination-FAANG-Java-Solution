class Solution {
    public boolean canJump(int[] nums) {
        
        int finall = nums.length - 1;
        
        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i] >= finall){
                finall=i;
            }
        }
        
        if(finall == 0){
            return true;
        }
        
        return false;
    }
    
}