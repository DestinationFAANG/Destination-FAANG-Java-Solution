class Solution {
    public int rob(int[] nums) {
     
       
        int rob1 = 0;
        int rob2 = 0;
        int max1 = nums[0];
        int max2 = 0;
        
        for(int i=0; i<nums.length-1; i++){
            max1= Math.max(rob1+nums[i], rob2);
            rob1= rob2;
            rob2= max1;
        }
        
        rob1=0;
        rob2=0;
        
        for(int i=1; i<nums.length; i++){
            max2= Math.max(rob1+nums[i], rob2);
            rob1= rob2;
            rob2= max2;
        }
        
        return Math.max(max1, max2);
    }
}