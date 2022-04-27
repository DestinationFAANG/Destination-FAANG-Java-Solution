class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int result = nums[0];
        
        for(int i = 0; i<nums.length; i++){
            
            int temp = maxProduct* nums[i];
            maxProduct = Math.max(nums[i], Math.max(maxProduct* nums[i], minProduct* nums[i]));
            minProduct = Math.min(nums[i], Math.min(temp, minProduct * nums[i]));
            
            result = Math.max(result, Math.max(minProduct, maxProduct));
        }
        
        return result;
    }
}