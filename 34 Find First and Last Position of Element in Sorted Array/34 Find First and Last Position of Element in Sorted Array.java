// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// Video Solution: https://www.youtube.com/watch?v=aPD6g96fRO4

// **************** Java Solution ***********************


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = this.findBound(nums, target, true);

        if(first == -1){
            return new int[]{-1,-1};
        }

        int last = this.findBound(nums, target, false);
        
        return new int[]{first,last};
    }

    public int findBound(int[] nums, int target, boolean isFirst){

        int start = 0;
        int end = nums.length - 1;

        while(start<= end){
            int mid = (start+end)/2;

            if(nums[mid] == target ){
                if(isFirst){

                if(mid == start || nums[mid-1]!= target){
                    return mid;
                }

                end = mid-1;

            }

            else{
                if(mid == end || nums[mid+1] != target){
                    return mid;
                }
                start = mid+1;
            }


            }
            
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }

        }
        return -1;

    }

