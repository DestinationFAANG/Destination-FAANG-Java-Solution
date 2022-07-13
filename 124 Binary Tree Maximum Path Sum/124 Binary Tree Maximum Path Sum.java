//LeetCode Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
//Youtube Link: https://youtu.be/6wv9yMSenvQ


class Solution {
    
    int maxSum = Integer.MIN_VALUE;
    
    public int maxGain(TreeNode node){
        
        if(node == null){
            return 0;
        }
        
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right),0);
        
        int priceNewPath = node.val + leftGain + rightGain;
        
        maxSum = Math.max(maxSum, priceNewPath);
        
        return node.val+Math.max(leftGain, rightGain);
        
    }
    
    public int maxPathSum(TreeNode root) {
        
        maxGain(root);
        return maxSum;
        
    }
}
