//Leetcode Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
//Youtube Link: https://www.youtube.com/watch?v=IAMk9ZSpvjQ
//**************** Java Solution ***********************

class Solution {
    public int maxDepth(TreeNode root) {
        
        
        if(root == null){
            return 0;
        }
        else{
            int leftmax= maxDepth(root.left);
            int rightmax = maxDepth(root.right);
            return java.lang.Math.max(leftmax, rightmax) + 1;
        }
        
    }
}
