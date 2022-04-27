class Solution {
    public int trap(int[] height) {
       int left = 0;
        int right = height.length - 1;
        
        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];
        
        while(left<right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax-height[left] >0){
                    total=total+leftMax-height[left];
                }
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                if(rightMax - height[right] > 0){
                    total = total+rightMax-height[right];
                }
                right--;
            }
        }
        return total;
    }
}