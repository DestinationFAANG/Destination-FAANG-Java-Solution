Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Video Solution: https://www.youtube.com/watch?v=Dr69TSfv9JI
// **************** Java Solution ***********************


class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length -1;
        int ans = nums[0];
        
        if(nums.length == 1){
            return nums[0];
        }
        
        while(left<=right){
            if(nums[left] < nums[right]){
                ans = Math.min(ans, nums[left]);
            }
            int mid = (left+right)/2;
            
            ans = Math.min(ans, nums[mid]);
            if(nums[left] <= nums[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        
        return ans;
        
    }
}
