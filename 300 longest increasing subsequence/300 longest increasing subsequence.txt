class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int [] Lis = new int[nums.length];
        Arrays.fill(Lis, 1);
        int max=1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    Lis[i] = Math.max(Lis[i], 1+Lis[j]);
                    max = Math.max(max, Lis[i]);
                }
            }
        }
        
        return max;
        
    }
}