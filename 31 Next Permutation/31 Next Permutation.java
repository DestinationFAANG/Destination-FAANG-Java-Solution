// Most Asked Problems at FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

// Video Solution: https://www.youtube.com/watch?v=oc3OOtGmH6U 

**************** Java Solution ***********************


class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length-2;
        
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums, i+1);
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i){
        int j= nums.length-1;
        
        while(i<j){
            swap(nums, j, i);
            i++;
            j--;
        }
    }

    
}
