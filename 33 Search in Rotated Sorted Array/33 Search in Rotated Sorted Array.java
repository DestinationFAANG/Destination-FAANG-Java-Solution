// Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
// Video Solution: https://www.youtube.com/watch?v=sE_4DzVc71w
// Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

// **************** Java Solution ***********************


class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[left] <= nums[mid]){
                if(target < nums[left] || target > nums[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            else{
                if(target > nums[right] || target < nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        
        return -1;
    }
}
