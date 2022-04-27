class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left<right){
            
            int width = Math.min(height[left], height[right]);
            int length = right - left;
            
            max = Math.max(max, width*length);
            
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return max;
        
    }
}