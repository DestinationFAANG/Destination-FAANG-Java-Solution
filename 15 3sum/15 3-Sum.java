class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i<nums.length && nums[i] <=0; i++){
            if (i == 0 || nums[i] != nums[i-1]){
                twoSum2(nums, i, result);
            }
        }
        
        return result;
        
    }
    
    void twoSum2(int[] nums, int i, List<List<Integer>> result){
        int left = i+1;
        int right = nums.length - 1;
        
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            
            if(sum < 0){
                ++left;
            }
            else if (sum > 0){
                --right;
            }
            else{
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while(left < right && nums[left] == nums[left-1]){
                    ++left;
                }
            }
        }
    }
}