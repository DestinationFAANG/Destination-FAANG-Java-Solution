// Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
// Video Solution: https://www.youtube.com/watch?v=OuRQ_TCCjsU
// Leetcode Link: https://leetcode.com/problems/maximum-product-subarray/

**************** Java Solution ***********************


class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        int result = max;
        
        for(int i=1; i<nums.length; i++){
            int cur = nums[i];
            int temp = Math.max(cur, Math.max(max*cur, min*cur));
            min = Math.min(cur, Math.min(min*cur, max*cur));
            max = temp;
            
            result = Math.max(result, max);
        }
        
        return result;
        
    }
}
