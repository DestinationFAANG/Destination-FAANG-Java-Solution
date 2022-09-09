// Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
// Video Solution: https://www.youtube.com/watch?v=c9ywRRJcP1Y
// Leetcode Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right= numbers.length - 1;
        
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right = right - 1;
            }
            else if(numbers[left] + numbers[right] < target){
                left = left+1;
            }
            else{
                return new int[]{left+1, right+1};
            }
        }
        
        return null;
    }
}
